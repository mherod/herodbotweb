package dev.herod.foursquare

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Venue(
        @SerialName("beenHere")
        val beenHere: BeenHere? = null,
        @SerialName("categories")
        val categories: List<Category?>? = null,
        @SerialName("contact")
        val contact: Contact? = null,
        @SerialName("hasPerk")
        val hasPerk: Boolean? = null,
        @SerialName("hereNow")
        val hereNow: HereNow? = null,
        @SerialName("id")
        val id: String? = null,
        @SerialName("location")
        val location: Location? = null,
        @SerialName("name")
        val name: String? = null,
        @SerialName("referralId")
        val referralId: String? = null,
        @SerialName("stats")
        val stats: Stats? = null,
        @SerialName("venuePage")
        val venuePage: VenuePage? = null,
        @SerialName("verified")
        val verified: Boolean? = null
)
