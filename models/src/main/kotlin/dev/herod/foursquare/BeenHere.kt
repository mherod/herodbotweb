package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BeenHere(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("lastCheckinExpiredAt")
    val lastCheckinExpiredAt: Int? = null,
    @SerialName("marked")
    val marked: Boolean? = null,
    @SerialName("unconfirmedCount")
    val unconfirmedCount: Int? = null
)
