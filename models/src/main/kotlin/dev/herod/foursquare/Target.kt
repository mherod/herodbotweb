package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Target(
    @SerializedName("object")
    val objectX: Object = Object(),
    @SerializedName("type")
    val type: String = ""
)
