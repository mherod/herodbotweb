package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VenuePage(
        @SerialName("id")
        val id: String? = null
)
