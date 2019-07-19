package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class StatsX(
    @SerializedName("checkinsCount")
    val checkinsCount: Int = 0,
    @SerializedName("tipCount")
    val tipCount: Int = 0,
    @SerializedName("usersCount")
    val usersCount: Int = 0,
    @SerializedName("visitsCount")
    val visitsCount: Int = 0
)
