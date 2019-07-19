package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("key")
    val key: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("prefix")
    val prefix: String = "",
    @SerializedName("sizes")
    val sizes: List<Int> = listOf()
)
