package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
        @SerialName("confident")
        val confident: Boolean? = null,
        @SerialName("venues")
        val venues: List<Venue?>? = null
)
