package dev.herod.bot.web.framework.routes

import ch.qos.logback.core.util.OptionHelper.getEnv
import dev.herod.bot.web.respondJson
import dev.herod.foursquare.FoursquareVenueResponse
import io.ktor.application.call
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.routing.Route
import io.ktor.routing.get
import javax.inject.Inject

class FoursquareRoutesInstaller @Inject constructor(private val httpClient: HttpClient) : RoutesInstaller {

    override fun install(route: Route) {

        route.get {
            call.respondJson {
                httpClient.get<FoursquareVenueResponse> {
                    url("https://api.foursquare.com/v2/venues/search?ll=${call.parameters["lon"]},${call.parameters["lat"]}&client_id=${getEnv("FOURSQUARE_CLIENT_ID")}&client_secret=${getEnv("FOURSQUARE_CLIENT_SECRET")}&v=20180323")
                }
            }
        }
    }
}
