package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonzoFeedRequest(
    @SerialName("account_id")
    val accountId: String = "",
    @SerialName("params")
    val params: Params = Params(),
    @SerialName("type")
    val type: String = "",
    @SerialName("url")
    val url: String = ""
)
