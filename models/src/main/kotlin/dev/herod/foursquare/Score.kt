package dev.herod.foursquare

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("scores")
    val scores: List<ScoreX> = listOf(),
    @SerializedName("total")
    val total: Int = 0
)
