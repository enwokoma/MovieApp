package com.example.movieapp.data

import com.example.movieapp.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

class MovieRepository {
    private val apiKey = "cec59543e562310263b41217d7173b6e" // Replace with your actual API key
    private val apiService: MovieApiService = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApiService::class.java)

    suspend fun getPopularMovies(page: Int): List<Movie> {
        val response = apiService.getPopularMovies(apiKey, page)
        return response.results
    }
}