package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class BeenHereX(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("lastCheckinExpiredAt")
    val lastCheckinExpiredAt: Int = 0,
    @SerializedName("marked")
    val marked: Boolean = false,
    @SerializedName("unconfirmedCount")
    val unconfirmedCount: Int = 0
)
