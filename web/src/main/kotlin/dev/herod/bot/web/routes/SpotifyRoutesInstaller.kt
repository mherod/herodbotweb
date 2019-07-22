package dev.herod.bot.web.routes

import dev.herod.bot.spotify.SpotifyClient
import dev.herod.bot.web.framework.RoutesInstaller
import io.ktor.application.call
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import javax.inject.Inject

class SpotifyRoutesInstaller @Inject constructor(private val spotifyClient: SpotifyClient) : RoutesInstaller {

    override fun install(route: Route) {

        route.get("/oauth") {
            call.respondRedirect(spotifyClient.oauthAuthenticationUrl)
        }

        route.get("/oauth_redirect") {
            runCatching {
                spotifyClient.requestAccessToken("${call.parameters["code"]}")
            }.onFailure {
                call.respondRedirect(spotifyClient.oauthAuthenticationUrl)
            }.onSuccess { token ->
                call.respondText { "$token" }
            }
        }
    }
}
