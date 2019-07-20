package dev.herod.monzo

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerializedName("account_id")
    @SerialName("account_id")
    val accountId: String = "",
    @SerialName("amount")
    val amount: Int = 0,
    @SerialName("category")
    val category: String = "",
    @SerialName("created")
    val created: String = "",
    @SerialName("currency")
    val currency: String = "",
    @SerialName("description")
    val description: String = "",
    @SerialName("id")
    val id: String = "",
    @SerializedName("is_load")
    @SerialName("is_load")
    val isLoad: Boolean = false,
    @SerialName("merchant")
    val merchant: Merchant = Merchant(),
    @SerialName("settled")
    val settled: String = ""
)
