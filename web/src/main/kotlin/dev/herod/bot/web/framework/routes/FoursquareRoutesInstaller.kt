package dev.herod.bot.web.framework.routes

import dev.herod.bot.foursquare.FoursquareClient
import dev.herod.bot.web.framework.RoutesInstaller
import dev.herod.monzo.MonzoTransactionWebhook
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import javax.inject.Inject

class FoursquareRoutesInstaller @Inject constructor(private val foursquareClient: FoursquareClient) : RoutesInstaller {

    override fun install(route: Route) {

        route.post("/monzo") {
            val receive = call.receive<MonzoTransactionWebhook>()
            val name = receive.data.merchant.name
            val address = receive.data.merchant.address
            val venue = foursquareClient.searchVenue(
                    longitude = "${address.longitude}",
                    latitude = "${address.latitude}",
                    intent = "match",
                    query = name
            ).response?.venues?.firstOrNull()
            venue?.id?.let { venueId ->
                foursquareClient.venueCheckin(venueId)
            }
            call.respond(HttpStatusCode.Accepted)
        }
    }
}
