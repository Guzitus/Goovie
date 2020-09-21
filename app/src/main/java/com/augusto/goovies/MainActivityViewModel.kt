package com.augusto.goovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.augusto.domain.GetMoviesUseCase
import com.augusto.domain.SearchMoviesUseCase
import com.augusto.domain.model.Movie

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel(
  private val getMoviesUseCase: GetMoviesUseCase,
  private val searchMoviesUseCase: SearchMoviesUseCase

) : ViewModel() {

    private val _moviesObservable = MutableLiveData<List<Movie>>()
    val moviesObservable: LiveData<List<Movie>> = _moviesObservable

    private var searchJob: Job? = null

    private var currentList = emptyList<Movie>()

    fun getMovies() = viewModelScope.launch {
        currentList = getMoviesUseCase.execute(Unit)
        _moviesObservable.value = currentList
    }

    fun searchMovies(name: String) {
        searchJob?.cancel()
        if (name.isEmpty()) {
            _moviesObservable.value = currentList
            return
        }
        searchJob = viewModelScope.launch {
            val movies =  try {
                searchMoviesUseCase.execute(name)
            } catch (error: Exception) {
                null
            }
            _moviesObservable.value = movies ?: emptyList()
        }
    }

}