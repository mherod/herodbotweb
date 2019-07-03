package dev.herod.monzo

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
        @Optional
        @SerialName("account_id")
        val accountId: String = "",
        @Optional
        @SerialName("amount")
        val amount: Int = 0,
        @Optional
        @SerialName("category")
        val category: String = "",
        @Optional
        @SerialName("created")
        val created: String = "",
        @Optional
        @SerialName("currency")
        val currency: String = "",
        @Optional
        @SerialName("description")
        val description: String = "",
        @Optional
        @SerialName("id")
        val id: String = "",
        @Optional
        @SerialName("is_load")
        val isLoad: Boolean = false,
        @Optional
        @SerialName("merchant")
        val merchant: Merchant = Merchant(),
        @Optional
        @SerialName("settled")
        val settled: String = ""
)
