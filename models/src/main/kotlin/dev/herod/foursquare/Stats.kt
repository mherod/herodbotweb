package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats(
        @Optional
        @SerialName("checkinsCount")
        val checkinsCount: Int?,
        @Optional
        @SerialName("tipCount")
        val tipCount: Int?,
        @Optional
        @SerialName("usersCount")
        val usersCount: Int?,
        @Optional
        @SerialName("visitsCount")
        val visitsCount: Int?
)
