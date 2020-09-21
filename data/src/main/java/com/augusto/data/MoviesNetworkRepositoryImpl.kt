package com.augusto.data

import com.augusto.network.NetworkRequester
import com.augusto.domain.model.BaseResult
import com.augusto.domain.model.Movie
import com.augusto.domain.repository.MoviesRepository

class MoviesNetworkRepositoryImpl(
    private val moviesAPI: MoviesAPI
) : MoviesRepository {

    override suspend fun getMovies(): BaseResult<Movie>? {
        return NetworkRequester.request {
            return@request moviesAPI.getMoviesV2(MoviesConfig.KEY_MOVIES)
        }
    }

    override suspend fun searchMovies(name: String): BaseResult<Movie>? {
       return NetworkRequester.request {
            return@request moviesAPI.searchMovies(name, MoviesConfig.KEY_MOVIES)
        }
    }

}
