package dev.herod.bot.web.routes

import dev.herod.bot.web.auth.checkAccessToken
import dev.herod.bot.web.framework.RoutesInstaller
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.util.toMap
import javax.inject.Inject

class WebRoutesInstaller @Inject constructor() : RoutesInstaller {
    override fun install(route: Route) {
        route.get {
            call.respondText("Hello $call, ${call.request.headers.toMap()}")
        }
        route.get("/") {
            call.respond(HttpStatusCode.OK)
        }
        route.get("/check") {
            val token = call.parameters["token"] ?: throw Throwable()
            val found = checkAccessToken(token)

            call.run {
                respondText {
                    "Out: $found"
                }
            }
        }
    }
}
