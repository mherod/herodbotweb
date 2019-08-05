package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Merchant(
    @SerialName("address")
    val address: Address = Address(),
    @SerialName("category")
    val category: String = "",
    @SerialName("created")
    val created: String = "",
    @SerialName("emoji")
    val emoji: String = "",
    @SerialName("group_id")
    val groupId: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("logo")
    val logo: String = "",
    @SerialName("name")
    val name: String = ""
)
