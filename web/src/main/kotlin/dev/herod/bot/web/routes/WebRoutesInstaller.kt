package dev.herod.bot.web.routes

import dev.herod.bot.web.auth.checkAccessToken
import dev.herod.bot.web.framework.RoutesInstaller
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import javax.inject.Inject

class WebRoutesInstaller @Inject constructor() : RoutesInstaller {
    override fun install(route: Route) {
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
