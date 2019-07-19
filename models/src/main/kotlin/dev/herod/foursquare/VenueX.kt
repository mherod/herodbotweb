package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class VenueX(
    @SerializedName("beenHere")
    val beenHere: BeenHereX = BeenHereX(),
    @SerializedName("categories")
    val categories: List<CategoryX> = listOf(),
    @SerializedName("contact")
    val contact: ContactX = ContactX(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("location")
    val location: LocationX = LocationX(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("reasons")
    val reasons: Reasons = Reasons(),
    @SerializedName("stats")
    val stats: StatsX = StatsX(),
    @SerializedName("verified")
    val verified: Boolean = false
)
