package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocaleUk(
    @SerialName("account_number")
    val accountNumber: String = "",
    @SerialName("sort_code")
    val sortCode: String = ""
)
