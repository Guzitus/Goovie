package com.augusto.goovies.movies

import com.augusto.domain.model.Movie

interface OnMoviesClickListener {
    fun OnMovieItemClicked(movie: Movie)
}