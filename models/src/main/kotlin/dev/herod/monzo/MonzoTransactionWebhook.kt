package dev.herod.monzo


import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonzoTransactionWebhook(
        @Optional
        @SerialName("data")
        val `data`: Data = Data(),
        @Optional
        @SerialName("type")
        val type: String = ""
)
