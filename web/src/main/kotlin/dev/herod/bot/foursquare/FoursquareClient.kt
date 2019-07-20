package dev.herod.bot.foursquare

import dev.herod.foursquare.FoursquareCheckinResponse
import dev.herod.foursquare.FoursquareVenueResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.util.url
import java.lang.System.getenv
import javax.inject.Inject

class FoursquareClient @Inject constructor(private val httpClient: HttpClient) {

    fun getOauthAuthenticationUrl(): String = url {
        protocol = URLProtocol.HTTPS
        host = "foursquare.com"
        path("oauth2", "authenticate")
        parameters.append("client_id", getenv("FOURSQUARE_CLIENT_ID"))
        parameters.append("response_type", "code")
        parameters.append("redirect_uri", "https://bot.herod.dev/api/4sq/oauth_redirect")
    }

    fun getOauthAccessTokenUrl(code: String?): String = url {
        protocol = URLProtocol.HTTPS
        host = "foursquare.com"
        path("oauth2", "authenticate")
        parameters.append("client_id", getenv("FOURSQUARE_CLIENT_ID"))
        parameters.append("client_secret", getenv("FOURSQUARE_CLIENT_SECRET"))
        parameters.append("grant_type", "authorization_code")
        parameters.append("redirect_uri", "https://bot.herod.dev/api/4sq/oauth_redirect")
        parameters.append("code", "$code")
    }

    suspend fun searchVenue(
        longitude: String?,
        latitude: String?,
        intent: String = "checkin",
        query: String
    ): FoursquareVenueResponse {
        return httpClient.get {
            url(
                "https://api.foursquare.com/v2/venues/search?intent=$intent&query=$query&ll=$longitude,$latitude&client_id=${getenv(
                    "FOURSQUARE_CLIENT_ID"
                )}&client_secret=${getenv("FOURSQUARE_CLIENT_SECRET")}&v=20180323"
            )
        }
    }

    suspend fun venueCheckin(venueId: String): FoursquareCheckinResponse {

        val params = mapOf(
            "venueId" to venueId,
            "client_id" to getenv("FOURSQUARE_CLIENT_ID"),
            "client_secret" to getenv("FOURSQUARE_CLIENT_SECRET"),
            "oauth_token" to getenv("FOURSQUARE_ACCESS_TOKEN"),
            "v" to "20180323"
        )

        return httpClient.post {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.foursquare.com"
                path("v2", "checkins", "add")
                params.forEach { (key, value) ->
                    parameters.append(key, value)
                }
            }
            contentType(ContentType.Application.Json)
            body = params
        }
    }
}
