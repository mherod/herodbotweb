package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Likes(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("groups")
    val groups: List<Any> = listOf()
)
