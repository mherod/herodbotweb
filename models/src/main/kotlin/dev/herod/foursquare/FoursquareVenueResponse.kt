package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoursquareVenueResponse(
    @SerialName("meta")
    val meta: Meta? = null,
    @SerialName("response")
    val response: Response? = null
)
