package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Venue(
        @SerialName("beenHere")
        val beenHere: BeenHere?,
        @SerialName("categories")
        val categories: List<Category?>?,
        @SerialName("contact")
        val contact: Contact?,
        @SerialName("hasPerk")
        val hasPerk: Boolean?,
        @SerialName("hereNow")
        val hereNow: HereNow?,
        @SerialName("id")
        val id: String?,
        @SerialName("location")
        val location: Location?,
        @SerialName("name")
        val name: String?,
        @SerialName("referralId")
        val referralId: String?,
        @SerialName("stats")
        val stats: Stats?,
        @SerialName("venuePage")
        val venuePage: VenuePage?,
        @SerialName("verified")
        val verified: Boolean?
)
