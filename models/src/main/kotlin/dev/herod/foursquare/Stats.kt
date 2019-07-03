package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    @SerialName("checkinsCount")
    val checkinsCount: Int? = null,
    @SerialName("tipCount")
    val tipCount: Int? = null,
    @SerialName("usersCount")
    val usersCount: Int? = null,
    @SerialName("visitsCount")
    val visitsCount: Int? = null
)
