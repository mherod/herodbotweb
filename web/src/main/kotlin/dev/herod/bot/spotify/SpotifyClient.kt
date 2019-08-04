package dev.herod.bot.spotify

import dev.herod.AccessTokenResponse
import dev.herod.bot.EnvPropertyFinder
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.http.Parameters
import io.ktor.http.URLProtocol
import io.ktor.util.url
import javax.inject.Inject

class SpotifyClient @Inject constructor(private val httpClient: HttpClient) {

    val oauthAuthenticationUrl: String
        get() = url {
            protocol = URLProtocol.HTTPS
            host = "accounts.spotify.com"
            path("authorize")
            with(parameters) {
                append("client_id", EnvPropertyFinder.getEnv("SPOTIFY_CLIENT_ID"))
                append("response_type", "code")
                append("redirect_uri", "https://bot.herod.dev/api/spotify/oauth_redirect")
            }
        }

    suspend fun requestAccessToken(code: String?): AccessTokenResponse {
        return httpClient.post {
            url {
                protocol = URLProtocol.HTTPS
                host = "accounts.spotify.com"
                path("api", "token")
                body = FormDataContent(
                    Parameters.build {
                        append("client_id", EnvPropertyFinder.getEnv("SPOTIFY_CLIENT_ID"))
                        append("client_secret", EnvPropertyFinder.getEnv("SPOTIFY_CLIENT_SECRET"))
                        append("grant_type", "authorization_code")
                        append("redirect_uri", "https://bot.herod.dev/api/spotify/oauth_redirect")
                        append("code", "$code")
                    }
                )
            }
        }
    }
}
