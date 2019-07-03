package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaymentDetails(
        @SerialName("locale_uk")
        val localeUk: LocaleUk = LocaleUk()
)
