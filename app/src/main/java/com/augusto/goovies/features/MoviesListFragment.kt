package com.augusto.goovies.features

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.augusto.domain.model.Movie
import com.augusto.goovies.MoviesViewModel
import com.augusto.goovies.R
import com.augusto.goovies.movies.MoviesAdapter
import com.augusto.goovies.movies.OnMoviesClickListener
import kotlinx.android.synthetic.main.fragment_movies_list.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class MoviesListFragment  : Fragment(R.layout.fragment_movies_list), OnMoviesClickListener{
    val adapter = MoviesAdapter(this)
    val mainActivityViewModel : MoviesViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configMoviesList()
        observeLiveData()
        mainActivityViewModel.getMovies()

        ed_seach_movies.addTextChangedListener {
            mainActivityViewModel.searchMovies(it.toString())
        }
    }
    private fun configMoviesList() {
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    private fun observeLiveData() {
        mainActivityViewModel.moviesObservable.observe(viewLifecycleOwner, Observer {
            empty_container.isVisible = it.isEmpty()
            adapter.submitList(it)
        })
    }

    override fun OnMovieItemClicked(movie: Movie) {
        findNavController().navigate(MoviesListFragmentDirections.actionNavMoviesListToNavMovieDetails(movie))
    }
}