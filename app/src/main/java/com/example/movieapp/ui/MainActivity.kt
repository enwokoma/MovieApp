package com.example.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.viewmodel.MoviesViewModel

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

private const val BASE_URL = "https://api.themoviedb.org/3/"

class MainActivity : AppCompatActivity() {
    private lateinit var moviesRecyclerView: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesRecyclerView = findViewById(R.id.moviesRecyclerView)
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesAdapter = MoviesAdapter(emptyList())
        moviesRecyclerView.adapter = moviesAdapter

        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        moviesViewModel.movies.observe(this, { movies ->
            moviesAdapter = MoviesAdapter(movies)
            moviesRecyclerView.adapter = moviesAdapter
        })
    }
}
