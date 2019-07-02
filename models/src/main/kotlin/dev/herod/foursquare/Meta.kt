package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
        @SerialName("code")
        val code: Int? = null,
        @SerialName("requestId")
        val requestId: String? = null
)
