package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
        @Optional
        @SerialName("code")
        val code: Int?,
        @Optional
        @SerialName("requestId")
        val requestId: String?
)
