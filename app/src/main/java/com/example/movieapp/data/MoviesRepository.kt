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

object MoviesRepository {
    private val apiKey = "cec59543e562310263b41217d7173b6e"
    private val api: MoviesApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MoviesApiService::class.java)
    }

    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<MoviesApiResponse> {
                override fun onResponse(
                    call: Call<MoviesApiResponse>,
                    response: Response<MoviesApiResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MoviesApiResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}