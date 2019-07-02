package dev.herod.bot.foursquare

import ch.qos.logback.core.util.OptionHelper
import dev.herod.foursquare.FoursquareVenueResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import javax.inject.Inject

class FoursquareClient @Inject constructor(private val httpClient: HttpClient) {

    suspend fun venueSearch(longitude: String?, latitude: String?, intent: String = "checkin", query: String): FoursquareVenueResponse {
        return httpClient.get {
            url("https://api.foursquare.com/v2/venues/search?intent=$intent&query=$query&ll=$longitude,$latitude&client_id=${OptionHelper.getEnv("FOURSQUARE_CLIENT_ID")}&client_secret=${OptionHelper.getEnv("FOURSQUARE_CLIENT_SECRET")}&v=20180323")
        }
    }

    suspend fun venueCheckin(venueId: String): String {
        return httpClient.post {
            url("https://api.foursquare.com/v2/checkins/add?venueId=$venueId&client_id=${OptionHelper.getEnv("FOURSQUARE_CLIENT_ID")}&client_secret=${OptionHelper.getEnv("FOURSQUARE_CLIENT_SECRET")}&v=20180323")
        }
    }
}
