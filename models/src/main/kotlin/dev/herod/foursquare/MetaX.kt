package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class MetaX(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("requestId")
    val requestId: String = ""
)
