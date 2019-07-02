package dev.herod.monzo


import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
        @Optional
        @SerialName("address")
        val address: String = "",
        @Optional
        @SerialName("city")
        val city: String = "",
        @Optional
        @SerialName("country")
        val country: String = "",
        @Optional
        @SerialName("latitude")
        val latitude: Double = 0.0,
        @Optional
        @SerialName("longitude")
        val longitude: Double = 0.0,
        @Optional
        @SerialName("postcode")
        val postcode: String = "",
        @Optional
        @SerialName("region")
        val region: String = ""
)
