package com.augusto.domain.repository

import androidx.lifecycle.LiveData
import com.augusto.domain.model.BaseResult
import com.augusto.domain.model.Movie

interface MoviesLocalRespository {
    suspend fun getMovies():List<Movie>
    suspend fun addMovies(list: List<Movie>)
}
