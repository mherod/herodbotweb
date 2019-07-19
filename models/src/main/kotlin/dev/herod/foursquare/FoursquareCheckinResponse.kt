package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class FoursquareCheckinResponse(
    @SerializedName("meta")
    val meta: MetaX = MetaX(),
    @SerializedName("notifications")
    val notifications: List<Notification> = listOf(),
    @SerializedName("response")
    val response: ResponseX = ResponseX()
)
