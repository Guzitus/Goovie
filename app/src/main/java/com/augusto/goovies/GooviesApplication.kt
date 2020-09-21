package com.augusto.goovies

import android.app.Application
import com.augusto.goovies.di.moviesModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GooviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GooviesApplication)
            modules(moviesModules)
        }

    }
}