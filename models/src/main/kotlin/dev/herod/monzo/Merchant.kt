package dev.herod.monzo

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Merchant(
        @Optional
        @SerialName("address")
        val address: Address = Address(),
        @Optional
        @SerialName("category")
        val category: String = "",
        @Optional
        @SerialName("created")
        val created: String = "",
        @Optional
        @SerialName("emoji")
        val emoji: String = "",
        @Optional
        @SerialName("group_id")
        val groupId: String = "",
        @Optional
        @SerialName("id")
        val id: String = "",
        @Optional
        @SerialName("logo")
        val logo: String = "",
        @Optional
        @SerialName("name")
        val name: String = ""
)
