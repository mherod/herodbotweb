package dev.herod.bot.web.routes

import dev.herod.bot.web.framework.RoutesInstaller
import io.ktor.routing.Route
import io.ktor.routing.route
import javax.inject.Inject

class ApiRoutesInstaller @Inject constructor(
    private val foursquareRoutesInstaller: FoursquareRoutesInstaller,
    private val spotifyRoutesInstaller: SpotifyRoutesInstaller
) : RoutesInstaller {
    override fun install(route: Route) {
        with(route) {
            route("/4sq") {
                foursquareRoutesInstaller.install(this)
            }
            route("/spotify") {
                spotifyRoutesInstaller.install(this)
            }
        }
    }
}
