package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(
    @SerialName("preferred_first_name")
    val preferredFirstName: String = "",
    @SerialName("preferred_name")
    val preferredName: String = "",
    @SerialName("user_id")
    val userId: String = ""
)
