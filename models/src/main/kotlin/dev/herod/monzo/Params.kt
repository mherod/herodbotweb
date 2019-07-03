package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Params(
    @SerialName("body")
    val body: String = "",
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("title")
    val title: String = ""
)
