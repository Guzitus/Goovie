package com.augusto.goovies.di

import androidx.room.Room
import com.augusto.data.MoviesAPI
import com.augusto.data.MoviesConfig
import com.augusto.data.MoviesLocalRespositoryImpl
import com.augusto.data.MoviesNetworkRepositoryImpl
import com.augusto.domain.GetMoviesUseCase
import com.augusto.domain.SearchMoviesUseCase
import com.augusto.domain.repository.MoviesLocalRespository
import com.augusto.domain.repository.MoviesRepository
import com.augusto.goovies.MoviesViewModel
import com.augusto.local.GooviesDatabase
import com.augusto.network.movies.MoviesClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesModules = module {
    single {
        Room.databaseBuilder(androidContext(), GooviesDatabase::class.java, GooviesDatabase.name).build()
    }
    //module api
    single {
        MoviesClient.getClient(MoviesConfig.URL, MoviesAPI::class.java)
    }
    //module repository
    single {
        MoviesNetworkRepositoryImpl(get()) as MoviesRepository
    }
    single {
        MoviesLocalRespositoryImpl(get()) as MoviesLocalRespository
    }
    factory {
        GetMoviesUseCase(get(), get())
    }
    factory {
        SearchMoviesUseCase(get())
    }
    viewModel {
        MoviesViewModel(get(), get())
    }
}