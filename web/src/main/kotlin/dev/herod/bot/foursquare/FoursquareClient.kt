package dev.herod.bot.foursquare

import dev.herod.foursquare.FoursquareVenueResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import java.lang.System.getenv
import javax.inject.Inject

class FoursquareClient @Inject constructor(private val httpClient: HttpClient) {

    suspend fun searchVenue(longitude: String?, latitude: String?, intent: String = "checkin", query: String): FoursquareVenueResponse {
        return httpClient.get {
            url("https://api.foursquare.com/v2/venues/search?intent=$intent&query=$query&ll=$longitude,$latitude&client_id=${getenv("FOURSQUARE_CLIENT_ID")}&client_secret=${getenv("FOURSQUARE_CLIENT_SECRET")}&v=20180323")
        }
    }

    suspend fun venueCheckin(venueId: String): String {
        return httpClient.post {
            url("https://api.foursquare.com/v2/checkins/add?venueId=$venueId&client_id=${getenv("FOURSQUARE_CLIENT_ID")}&client_secret=${getenv("FOURSQUARE_CLIENT_SECRET")}&v=20180323")
            body = mapOf("venueId" to venueId)
        }
    }
}
