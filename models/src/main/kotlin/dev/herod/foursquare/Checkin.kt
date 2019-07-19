package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Checkin(
    @SerializedName("checkinShortUrl")
    val checkinShortUrl: String = "",
    @SerializedName("comments")
    val comments: Comments = Comments(),
    @SerializedName("createdAt")
    val createdAt: Int = 0,
    @SerializedName("editableUntil")
    val editableUntil: Long = 0,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isMayor")
    val isMayor: Boolean = false,
    @SerializedName("like")
    val like: Boolean = false,
    @SerializedName("likes")
    val likes: Likes = Likes(),
    @SerializedName("photos")
    val photos: Photos = Photos(),
    @SerializedName("posts")
    val posts: Posts = Posts(),
    @SerializedName("score")
    val score: Score = Score(),
    @SerializedName("timeZoneOffset")
    val timeZoneOffset: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("user")
    val user: User = User(),
    @SerializedName("venue")
    val venue: VenueX = VenueX()
)
