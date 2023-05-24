package com.example.movieapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): ApiResponse
}

