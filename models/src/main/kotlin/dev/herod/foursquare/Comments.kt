package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("items")
    val items: List<Any> = listOf()
)
