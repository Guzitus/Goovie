package com.augusto.domain

import com.augusto.domain.model.Movie
import com.augusto.domain.repository.MoviesRepository

class SearchMoviesUseCase(private val moviesRepository: MoviesRepository) :
    BaseUseCase<String, List<Movie>> {
    override suspend fun execute(params: String): List<Movie> {
        return moviesRepository.searchMovies(params)?.results ?: emptyList()
    }
}