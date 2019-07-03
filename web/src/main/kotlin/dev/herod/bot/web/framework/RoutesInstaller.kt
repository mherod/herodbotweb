package dev.herod.bot.web.framework

import io.ktor.routing.Route

interface RoutesInstaller {
    fun install(route: Route)
}
