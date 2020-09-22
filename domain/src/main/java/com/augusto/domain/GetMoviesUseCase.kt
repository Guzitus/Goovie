package com.augusto.domain

import com.augusto.domain.model.Movie
import com.augusto.domain.repository.MoviesLocalRespository
import com.augusto.domain.repository.MoviesRepository

class GetMoviesUseCase(
    private val moviesRepository: MoviesRepository,
    private val moviesLocalRespository: MoviesLocalRespository
) :
    BaseUseCase<Unit, List<Movie>> {
    override suspend fun execute(params: Unit): List<Movie> {
        return try {
            val movies = moviesRepository.getMovies()?.results

            moviesLocalRespository.takeIf { movies != null && movies.isNotEmpty() }
                ?.addMovies(movies!!)
            moviesLocalRespository.getMovies()
        } catch (error: Exception) {
            moviesLocalRespository.getMovies()
        }
    }
}