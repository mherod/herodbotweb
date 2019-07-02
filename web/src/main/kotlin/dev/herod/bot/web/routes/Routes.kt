package dev.herod.bot.web.routes

import dev.herod.bot.web.framework.routes.FoursquareRoutesInstaller
import dev.herod.bot.web.framework.routes.RoutesInstaller
import io.ktor.application.call
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import javax.inject.Inject

class Routes @Inject constructor(
        private val webRoutesInstaller: WebRoutesInstaller,
        private val foursquareRoutesInstaller: FoursquareRoutesInstaller
) : RoutesInstaller {

    override fun install(route: Route) {

        route.route("/") {
            get {
                call.respondText {
                    "Herodbot [ ${call.parameters} ]"
                }
            }
            webRoutesInstaller.install(this)
        }
        route.route("/api") {
            route("/4sq") {
                foursquareRoutesInstaller.install(this)
            }
        }
        route.get("dump") {
            println(System.getenv("DATABASE_URL"))
            call.respondRedirect {
                port = 443
                path("")
            }
        }
    }
}
