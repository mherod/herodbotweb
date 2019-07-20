package dev.herod.bot.web.framework.routes

import com.google.gson.Gson
import dev.herod.bot.db.DbConnection
import dev.herod.bot.foursquare.FoursquareClient
import dev.herod.bot.web.framework.RoutesInstaller
import dev.herod.bot.web.respondJson
import dev.herod.foursquare.FoursquareCheckinResponse
import dev.herod.foursquare.Venue
import dev.herod.monzo.MonzoTransactionWebhook
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import javax.inject.Inject

class FoursquareRoutesInstaller @Inject constructor(private val foursquareClient: FoursquareClient) : RoutesInstaller {

    override fun install(route: Route) {

        route.get("/oauth") {
            call.respondRedirect(foursquareClient.oauthAuthenticationUrl)
        }

        route.get("/oauth_redirect") {
            runCatching {
                foursquareClient.requestAccessToken("${call.parameters["code"]}")
            }.onFailure {
                call.respondRedirect(foursquareClient.oauthAuthenticationUrl)
            }.onSuccess { token ->
                DbConnection.getMyDbConnection().use { connection ->
                    connection.prepareStatement("INSERT INTO secrets (key, value)\nVALUES (?, ?)\nON CONFLICT (key) DO UPDATE SET value = excluded.value;")
                        .use { statement ->
                            statement.setString(1, "FOURSQUARE_ACCESS_TOKEN")
                            statement.setString(2, token.accessToken)
                            statement.execute()
                        }
                }
                call.respond(HttpStatusCode.Created)
            }
        }

        route.get("/search") {
            call.respondJson {
                foursquareClient.searchVenue(
                    longitude = "${parameters["lon"]}",
                    latitude = "${parameters["lat"]}",
                    query = "${parameters["q"]}"
                ).response?.venues.orEmpty()
            }
        }

        route.post("/checkin") {
            call.respondJson {
                parameters["id"].takeUnless { it.isNullOrBlank() }?.let { id ->
                    foursquareClient.venueCheckin(id)
                } ?: searchVenue(
                    longitude = parameters["lon"].takeUnless { it.isNullOrBlank() }!!.toDoubleOrNull()!!,
                    latitude = parameters["lat"].takeUnless { it.isNullOrBlank() }!!.toDoubleOrNull()!!,
                    name = "${parameters["id"].takeUnless { it.isNullOrBlank() }}"
                )?.checkin() ?: emptyList<String>()
            }
        }

        route.post("/monzo") {
            call.receive<String>().let { receive1 ->
                val receive = Gson().fromJson(receive1, MonzoTransactionWebhook::class.java)
                val name = receive.data.merchant.name
                val address = receive.data.merchant.address
                searchVenue(
                    longitude = address.longitude,
                    latitude = address.latitude,
                    name = name
                )?.checkin()?.let {
                    call.respond(HttpStatusCode.Created)
                } ?: run {
                    call.respond(HttpStatusCode.Conflict)
                }
            }
        }
    }

    private suspend fun searchVenue(
        longitude: Double,
        latitude: Double,
        name: String
    ): Venue? = foursquareClient.searchVenue(
        longitude = "$longitude",
        latitude = "$latitude",
        intent = "match",
        query = name
    ).response?.venues?.firstOrNull() ?: foursquareClient.searchVenue(
        longitude = "$longitude",
        latitude = "$latitude",
        query = name
    ).response?.venues?.firstOrNull()

    private suspend fun Venue.checkin(): FoursquareCheckinResponse? {
        return runCatching { id?.let { foursquareClient.venueCheckin(it) } }.getOrNull()
    }
}
