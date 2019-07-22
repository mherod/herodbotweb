package dev.herod.bot.spotify

import dev.herod.AccessTokenResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.http.URLProtocol
import io.ktor.util.url
import java.lang.System.getenv
import javax.inject.Inject

class SpotifyClient @Inject constructor(private val httpClient: HttpClient) {

    val oauthAuthenticationUrl: String
        get() = url {
            protocol = URLProtocol.HTTPS
            host = "accounts.spotify.com"
            path("authorize")
            with(parameters) {
                append("client_id", getenv("SPOTIFY_CLIENT_ID"))
                append("response_type", "code")
                append("redirect_uri", "https://bot.herod.dev/api/spotify/oauth_redirect")
            }
        }

    suspend fun requestAccessToken(code: String?): AccessTokenResponse {
        return httpClient.post {
            url {
                protocol = URLProtocol.HTTPS
                host = "foursquare.com"
                path("api", "token")
                with(parameters) {
                    append("client_id", getenv("SPOTIFY_CLIENT_ID"))
                    append("client_secret", getenv("SPOTIFY_CLIENT_SECRET"))
                    append("grant_type", "refresh_token")
                    append("redirect_uri", "https://bot.herod.dev/api/spotify/oauth_redirect")
                    append("code", "$code")
                }
            }
        }
    }
}
