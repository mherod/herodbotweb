package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class ItemXX(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("points")
    val points: Points = Points(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("type")
    val type: String = ""
)
