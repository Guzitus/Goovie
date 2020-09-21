package com.augusto.goovies

import androidx.appcompat.app.AppCompatActivity
import org.koin.android.viewmodel.ext.android.viewModel


class MoviesActivity : AppCompatActivity(R.layout.activity_movies) {
    val mainActivityViewModel : MoviesViewModel by viewModel()




}