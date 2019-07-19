package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Insights(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("items")
    val items: List<ItemXX> = listOf()
)
