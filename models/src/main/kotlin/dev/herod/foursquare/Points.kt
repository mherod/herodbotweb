package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Points(
    @SerializedName("image")
    val image: Image = Image(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("points")
    val points: Int = 0,
    @SerializedName("target")
    val target: Target = Target()
)
