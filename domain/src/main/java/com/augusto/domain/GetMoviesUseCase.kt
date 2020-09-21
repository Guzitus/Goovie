package com.augusto.domain

import com.augusto.domain.model.Movie
import com.augusto.domain.repository.MoviesRepository

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) :
    BaseUseCase<Unit, List<Movie>> {
    override suspend fun execute(params: Unit): List<Movie> {
        return moviesRepository.getMovies()?.results ?: emptyList()
    }
}