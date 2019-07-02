package dev.herod.foursquare

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
        @Optional
        @SerialName("icon")
        val icon: Icon?,
        @Optional
        @SerialName("id")
        val id: String?,
        @Optional
        @SerialName("name")
        val name: String?,
        @Optional
        @SerialName("pluralName")
        val pluralName: String?,
        @Optional
        @SerialName("primary")
        val primary: Boolean?,
        @Optional
        @SerialName("shortName")
        val shortName: String?
)
