package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
        @Optional
        @SerialName("cc")
        val cc: String?,
        @Optional
        @SerialName("city")
        val city: String?,
        @Optional
        @SerialName("country")
        val country: String?,
        @Optional
        @SerialName("crossStreet")
        val crossStreet: String?,
        @Optional
        @SerialName("distance")
        val distance: Int?,
        @Optional
        @SerialName("formattedAddress")
        val formattedAddress: List<String?>?,
        @Optional
        @SerialName("labeledLatLngs")
        val labeledLatLngs: List<LabeledLatLng?>?,
        @Optional
        @SerialName("lat")
        val lat: Double?,
        @Optional
        @SerialName("lng")
        val lng: Double?,
        @Optional
        @SerialName("postalCode")
        val postalCode: String?,
        @Optional
        @SerialName("state")
        val state: String?
)
