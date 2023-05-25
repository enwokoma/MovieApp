package com.example.movieapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

// Retrofit service interface for movie API requests
interface MoviesApiService {

    // Defines the GET request for fetching popular movies
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "cec59543e562310263b41217d7173b6e",
        @Query("page") page: Int
    ): Call<MoviesApiResponse>
}