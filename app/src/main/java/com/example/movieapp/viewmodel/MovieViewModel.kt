package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.MovieRepository
import com.example.movieapp.model.Movie
import kotlinx.coroutines.launch

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

class MoviesViewModel : ViewModel() {
    private val movieRepository = MovieRepository()
    private var currentPage = 1
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            val popularMovies = movieRepository.getPopularMovies(currentPage)
            _movies.value = popularMovies
            currentPage++
        }
    }
}
