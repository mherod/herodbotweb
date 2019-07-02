package dev.herod.bot.foursquare

import dev.herod.bot.web.DaggerTestWebComponent
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class FoursquareClientTest {

    @Inject
    lateinit var foursquareClient: FoursquareClient

    @Before
    fun setup() {
        DaggerTestWebComponent.builder().build().inject(this)
    }

    @Test
    fun venueSearch() {
        runBlocking {
            foursquareClient.venueSearch("53.475804", "-2.235979", query = "G-A-Y")
        }
    }
}
