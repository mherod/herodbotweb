package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class TargetXX(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("url")
    val url: String = ""
)
