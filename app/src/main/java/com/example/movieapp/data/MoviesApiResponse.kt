package com.example.movieapp.data

import com.example.movieapp.model.Movie
import com.google.gson.annotations.SerializedName

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/
data class MoviesApiResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
)
