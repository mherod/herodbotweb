package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonzoWhoAmIResponse(
    @SerialName("authenticated")
    val authenticated: Boolean = false,
    @SerialName("client_id")
    val clientId: String = "",
    @SerialName("user_id")
    val userId: String = ""
)
