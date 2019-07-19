package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class ScoreX(
    @SerializedName("icon")
    val icon: String = "",
    @SerializedName("message")
    val message: String = "",
    @SerializedName("points")
    val points: Int = 0,
    @SerializedName("target")
    val target: Target = Target()
)
