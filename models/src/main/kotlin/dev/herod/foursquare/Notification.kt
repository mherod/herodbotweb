package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Notification(
    @SerializedName("alert")
    val alert: Boolean = false,
    @SerializedName("item")
    val item: ItemX = ItemX(),
    @SerializedName("type")
    val type: String = ""
)
