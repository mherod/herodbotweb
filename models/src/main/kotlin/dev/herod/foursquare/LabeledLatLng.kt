package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LabeledLatLng(
        @Optional
        @SerialName("label")
        val label: String?,
        @Optional
        @SerialName("lat")
        val lat: Double?,
        @Optional
        @SerialName("lng")
        val lng: Double?
)
