package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class NotificationX(
    @SerializedName("item")
    val item: ItemXXX = ItemXXX(),
    @SerializedName("type")
    val type: String = ""
)
