package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    @SerialName("icon")
    val icon: Icon? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("pluralName")
    val pluralName: String? = null,
    @SerialName("primary")
    val primary: Boolean? = null,
    @SerialName("shortName")
    val shortName: String? = null
)
