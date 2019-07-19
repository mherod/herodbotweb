package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Object(
    @SerializedName("url")
    val url: String = ""
)
