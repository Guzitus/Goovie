package com.augusto.data

import com.augusto.data.mappers.toDomain
import com.augusto.domain.model.Movie
import com.augusto.domain.repository.MoviesLocalRespository
import com.augusto.local.GooviesDatabase

class MoviesLocalRespositoryImpl(
    private val db: GooviesDatabase
) : MoviesLocalRespository {
    override suspend fun getMovies(): List<Movie> = db.moviesDao().getMovies().map { it.toDomain() }

    override suspend fun addMovies(list: List<Movie>) {
        db.moviesDao().addMovies(list.map { it.toDomain() })
    }


}
