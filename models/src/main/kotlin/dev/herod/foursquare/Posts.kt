package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("textCount")
    val textCount: Int = 0
)
