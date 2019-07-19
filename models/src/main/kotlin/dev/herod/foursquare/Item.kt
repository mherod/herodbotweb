package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("reasonName")
    val reasonName: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("target")
    val target: TargetX = TargetX(),
    @SerializedName("type")
    val type: String = ""
)
