package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("firstName")
    val firstName: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("photo")
    val photo: Photo = Photo(),
    @SerializedName("relationship")
    val relationship: String = ""
)
