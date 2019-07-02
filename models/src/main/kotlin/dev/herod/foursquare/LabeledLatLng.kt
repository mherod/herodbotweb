package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LabeledLatLng(
        @SerialName("label")
        val label: String? = null,
        @SerialName("lat")
        val lat: Double? = null,
        @SerialName("lng")
        val lng: Double? = null
)
