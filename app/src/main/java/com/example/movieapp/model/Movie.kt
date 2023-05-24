package com.example.movieapp.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

data class Movie(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("release_date") val releaseDate: String
)

