package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class ResponseX(
    @SerializedName("checkin")
    val checkin: Checkin = Checkin(),
    @SerializedName("notifications")
    val notifications: List<Notification> = listOf(),
    @SerializedName("notificationsOrder")
    val notificationsOrder: List<String> = listOf()
)
