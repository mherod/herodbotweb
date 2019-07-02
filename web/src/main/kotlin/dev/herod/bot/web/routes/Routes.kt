package dev.herod.bot.web.routes

import io.ktor.application.call
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import dev.herod.bot.web.framework.routes.RoutesInstaller
import javax.inject.Inject

class Routes @Inject constructor(private val webRoutesInstaller: WebRoutesInstaller) : RoutesInstaller {

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
