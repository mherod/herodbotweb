package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
        @SerialName("cc")
        val cc: String? = null,
        @SerialName("city")
        val city: String? = null,
        @SerialName("country")
        val country: String? = null,
        @SerialName("crossStreet")
        val crossStreet: String? = null,
        @SerialName("distance")
        val distance: Int? = null,
        @SerialName("formattedAddress")
        val formattedAddress: List<String?>? = null,
        @SerialName("labeledLatLngs")
        val labeledLatLngs: List<LabeledLatLng?>? = null,
        @SerialName("lat")
        val lat: Double? = null,
        @SerialName("lng")
        val lng: Double? = null,
        @SerialName("postalCode")
        val postalCode: String? = null,
        @SerialName("state")
        val state: String? = null
)
