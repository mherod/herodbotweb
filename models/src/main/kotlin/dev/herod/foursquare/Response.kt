package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
        @Optional
        @SerialName("confident")
        val confident: Boolean?,
        @Optional
        @SerialName("venues")
        val venues: List<Venue?>?
)
