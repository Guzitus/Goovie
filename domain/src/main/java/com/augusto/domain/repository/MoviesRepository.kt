package com.augusto.domain.repository

import com.augusto.domain.model.BaseResult
import com.augusto.domain.model.Movie

interface MoviesRepository {
    suspend fun getMovies(): BaseResult<Movie>?
    suspend fun searchMovies(name: String): BaseResult<Movie>?
}
