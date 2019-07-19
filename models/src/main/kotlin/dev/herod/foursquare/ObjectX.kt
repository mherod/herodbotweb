package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class ObjectX(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("ignorable")
    val ignorable: Boolean = false,
    @SerializedName("target")
    val target: TargetXX = TargetXX(),
    @SerializedName("type")
    val type: String = ""
)
