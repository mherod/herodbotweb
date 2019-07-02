package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BeenHere(
        @Optional
        @SerialName("count")
        val count: Int?,
        @Optional
        @SerialName("lastCheckinExpiredAt")
        val lastCheckinExpiredAt: Int?,
        @Optional
        @SerialName("marked")
        val marked: Boolean?,
        @Optional
        @SerialName("unconfirmedCount")
        val unconfirmedCount: Int?
)
