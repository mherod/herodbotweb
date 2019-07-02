package dev.herod.bot.web.framework.routes

import dev.herod.bot.foursquare.FoursquareClient
import dev.herod.bot.web.respondJson
import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.get
import javax.inject.Inject

class FoursquareRoutesInstaller @Inject constructor(private val foursquareClient: FoursquareClient) : RoutesInstaller {

    override fun install(route: Route) {

        route.get {
            call.respondJson {
                foursquareClient.venueSearch(longitude = call.parameters["lon"], latitude = call.parameters["lat"])
            }
        }
    }
}
