package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonzoTransactionWebhook(
        @SerialName("data")
        val `data`: Data = Data(),
        @SerialName("type")
        val type: String = ""
)
