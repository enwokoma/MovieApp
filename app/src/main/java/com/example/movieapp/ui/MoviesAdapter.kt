package com.example.movieapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movieapp.R
import com.example.movieapp.model.Movie

/**
 * Created by Emmanuel Nwokoma (Gigabyte) on 5/24/2023
 **/

// Adapter class for the RecyclerView that displays movies
class MoviesAdapter(
    private var movies: MutableList<Movie>,
    private val onMovieClick: (movie: Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    // Creates the view holder for a movie item view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    // Returns the number of movies in the list
    override fun getItemCount(): Int = movies.size

    // Binds the movie data to the view holder
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    // Appends a list of movies to the existing list
    @SuppressLint("NotifyDataSetChanged")
    fun appendMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        // Notifies the adapter that items are inserted in a range
        notifyItemRangeInserted(
            this.movies.size,
            movies.size - 1
        )
        // Notifies the adapter that an item is inserted at the last position
        notifyItemInserted(this.movies.size - 1)
        // Notifies the adapter that the data set has changed
        notifyDataSetChanged()
    }

    // View holder class for a movie item
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)

        // Binds the movie data to the views
        fun bind(movie: Movie) {
            // Loads the movie poster image using Glide library
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                .transform(CenterCrop())
                .into(poster)

            // Sets a click listener on the item view
            itemView.setOnClickListener { onMovieClick.invoke(movie) }
        }
    }
}