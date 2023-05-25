package com.example.movieapp.data

import com.example.movieapp.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

// Repository class responsible for handling movie data
object MoviesRepository {
    private val api: MoviesApiService

    // Initialize the Retrofit instance and MoviesApiService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MoviesApiService::class.java)
    }

    // Fetches popular movies from the TMDB API
    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        // Make an API call to get popular movies
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<MoviesApiResponse> {
                override fun onResponse(
                    call: Call<MoviesApiResponse>,
                    response: Response<MoviesApiResponse>
                ) {
                    // Check if the response is successful
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            // Invoke the success callback with the fetched movies
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            // Invoke the error callback if the response body is null
                            onError.invoke()
                        }
                    } else {
                        // Invoke the error callback for unsuccessful response
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MoviesApiResponse>, t: Throwable) {
                    // Invoke the error callback for network failures
                    onError.invoke()
                }
            })
    }
}