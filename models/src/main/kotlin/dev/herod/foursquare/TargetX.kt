package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class TargetX(
    @SerializedName("object")
    val objectX: ObjectX = ObjectX(),
    @SerializedName("type")
    val type: String = ""
)
