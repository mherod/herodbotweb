package dev.herod.bot.web.framework.routes

import io.ktor.routing.Route

interface RoutesInstaller {
    fun install(route: Route)
}
