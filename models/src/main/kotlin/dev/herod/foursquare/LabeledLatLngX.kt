package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class LabeledLatLngX(
    @SerializedName("label")
    val label: String = "",
    @SerializedName("lat")
    val lat: Double = 0.0,
    @SerializedName("lng")
    val lng: Double = 0.0
)
