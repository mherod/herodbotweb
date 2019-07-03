package dev.herod.monzo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    @SerialName("address")
    val address: String = "",
    @SerialName("city")
    val city: String = "",
    @SerialName("country")
    val country: String = "",
    @SerialName("latitude")
    val latitude: Double = 0.0,
    @SerialName("longitude")
    val longitude: Double = 0.0,
    @SerialName("postcode")
    val postcode: String = "",
    @SerialName("region")
    val region: String = ""
)
