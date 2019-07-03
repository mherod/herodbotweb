package dev.herod.bot.foursquare

import dev.herod.bot.web.DaggerTestWebComponent
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import kotlin.test.assertEquals

class FoursquareClientTest {

    @Inject
    lateinit var foursquareClient: FoursquareClient

    @Before
    fun setup() {
        DaggerTestWebComponent.builder().build().inject(this)
    }

    @Test
    fun searchVenue() {
        runBlocking {
            val foursquareVenueResponse = foursquareClient.searchVenue(
                    longitude = "53.475804",
                    latitude = "-2.235979",
                    query = "G-A-Y"
            )
            val venue = foursquareVenueResponse.response!!.venues!!.first()!!
            assertEquals(venue.name, "G-A-Y")
            assertEquals(venue.location!!.city, "Manchester")
            assertEquals(venue.location!!.postalCode, "M1 3WB")
        }
    }
}
