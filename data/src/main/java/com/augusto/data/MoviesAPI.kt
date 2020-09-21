package com.augusto.data

import com.augusto.domain.model.BaseResult
import com.augusto.domain.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {


    @GET("movies/v2/reviews/picks.json")
    suspend fun getMoviesV2(@Query("api-key") keyValue: String): Response<BaseResult<Movie>>

    @GET("movies/v2/reviews/search.json")
    suspend fun searchMovies(
        @Query("query") movieName: String = "",
        @Query("api-key") keyValue: String
    ): Response<BaseResult<Movie>>


}

data class Teste(val value: String)