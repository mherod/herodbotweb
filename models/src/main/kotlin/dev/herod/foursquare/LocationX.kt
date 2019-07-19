package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class LocationX(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("cc")
    val cc: String = "",
    @SerializedName("city")
    val city: String = "",
    @SerializedName("country")
    val country: String = "",
    @SerializedName("crossStreet")
    val crossStreet: String = "",
    @SerializedName("formattedAddress")
    val formattedAddress: List<String> = listOf(),
    @SerializedName("labeledLatLngs")
    val labeledLatLngs: List<LabeledLatLngX> = listOf(),
    @SerializedName("lat")
    val lat: Double = 0.0,
    @SerializedName("lng")
    val lng: Double = 0.0,
    @SerializedName("postalCode")
    val postalCode: String = "",
    @SerializedName("state")
    val state: String = ""
)
