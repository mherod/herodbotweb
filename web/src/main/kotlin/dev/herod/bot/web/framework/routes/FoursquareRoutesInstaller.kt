package dev.herod.bot.web.framework.routes

import dev.herod.bot.db.DbConnection
import dev.herod.bot.foursquare.FoursquareClient
import dev.herod.bot.web.framework.RoutesInstaller
import dev.herod.bot.web.respondJson
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
            val code = call.parameters["code"]
            val token = foursquareClient.requestAccessToken(code)
            DbConnection.getMyDbConnection().use { connection ->
                connection.prepareStatement("INSERT INTO secrets (key, value)\nVALUES (?, ?)\nON CONFLICT DO UPDATE SET value = excluded.value;")
                    .use { statement ->
                        statement.setString(1, "FOURSQUARE_ACCESS_TOKEN")
                        statement.setString(2, "$token")
                        statement.execute()
                    }
            }
            call.respond(HttpStatusCode.Created)
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
                foursquareClient.venueCheckin("${parameters["id"]}")
            }
        }

        route.post("/monzo") {

            val receive = call.receive<MonzoTransactionWebhook>()
            val name = receive.data.merchant.name
            val address = receive.data.merchant.address

            val venue = foursquareClient.searchVenue(
                longitude = "${address.longitude}",
                latitude = "${address.latitude}",
                intent = "match",
                query = name
            ).response?.venues?.firstOrNull() ?: foursquareClient.searchVenue(
                longitude = "${address.longitude}",
                latitude = "${address.latitude}",
                query = name
            ).response?.venues?.firstOrNull()

            venue?.id?.let { venueId ->
                foursquareClient.venueCheckin(venueId)
            }
            call.respond(HttpStatusCode.Accepted)
        }
    }
}
