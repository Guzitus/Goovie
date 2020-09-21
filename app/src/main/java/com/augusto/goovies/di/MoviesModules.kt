package com.augusto.goovies.di

import com.augusto.data.MoviesConfig
import com.augusto.data.MoviesNetworkRepositoryImpl
import com.augusto.domain.GetMoviesUseCase
import com.augusto.goovies.MainActivityViewModel
import com.augusto.data.MoviesAPI
import com.augusto.domain.SearchMoviesUseCase
import com.augusto.network.movies.MoviesClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesModules = module {
    //module api
    single {
        MoviesClient.getClient(MoviesConfig.URL, MoviesAPI::class.java)
    }
    //module repository
    single {
        MoviesNetworkRepositoryImpl(get()) as com.augusto.domain.repository.MoviesRepository
    }
    factory {
        GetMoviesUseCase(get())
    }
    factory {
        SearchMoviesUseCase(get())
    }
    viewModel {
        MainActivityViewModel(get(), get())
    }
}