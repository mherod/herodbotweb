package dev.herod.foursquare

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoursquareVenueResponse(
    @SerializedName("meta")
    @SerialName("meta")
    val meta: Meta? = null,
    @SerializedName("response")
    @SerialName("response")
    val response: Response? = null
)
