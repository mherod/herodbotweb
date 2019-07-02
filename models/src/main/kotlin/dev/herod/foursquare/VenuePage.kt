package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VenuePage(
        @Optional
        @SerialName("id")
        val id: String?
)
