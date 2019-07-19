package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("insights")
    val insights: Insights = Insights()
)
