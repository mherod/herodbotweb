package dev.herod.foursquare

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerializedName("code")
    @SerialName("code")
    val code: Int? = null,
    @SerializedName("requestId")
    @SerialName("requestId")
    val requestId: String? = null
)
