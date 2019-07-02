package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Icon(
        @Optional
        @SerialName("prefix")
        val prefix: String?,
        @Optional
        @SerialName("suffix")
        val suffix: String?
)
