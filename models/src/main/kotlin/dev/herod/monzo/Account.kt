package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
        @SerialName("account_number")
        val accountNumber: String = "",
        @SerialName("closed")
        val closed: Boolean = false,
        @SerialName("country_code")
        val countryCode: String = "",
        @SerialName("created")
        val created: String = "",
        @SerialName("currency")
        val currency: String = "",
        @SerialName("description")
        val description: String = "",
        @SerialName("id")
        val id: String = "",
        @SerialName("owners")
        val owners: List<Owner> = listOf(),
        @SerialName("payment_details")
        val paymentDetails: PaymentDetails = PaymentDetails(),
        @SerialName("sort_code")
        val sortCode: String = "",
        @SerialName("type")
        val type: String = ""
)
