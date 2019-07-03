package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonzoAccountsResponse(
        @SerialName("accounts")
        val accounts: List<Account> = listOf()
)
