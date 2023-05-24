package com.example.movieapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

interface MoviesApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "c9c5ea53799624204822e99e30c87b54",
        @Query("page") page: Int
    ): Call<MoviesApiResponse>
}

