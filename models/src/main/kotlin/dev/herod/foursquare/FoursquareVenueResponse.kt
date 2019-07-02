package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoursquareVenueResponse(
        @Optional
        @SerialName("meta")
        val meta: Meta?,
        @Optional
        @SerialName("response")
        val response: Response?
)
