package com.augusto.goovies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.augusto.goovies.movies.MoviesAdapter
import com.augusto.goovies.movies.OnMoviesClickListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main), OnMoviesClickListener {

    val adapter = MoviesAdapter(this)
    val mainActivityViewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        mainActivityViewModel.moviesObservable.observe(this, Observer {
            empty_container.isVisible = it.isEmpty()
            adapter.submitList(it)
        })
    }

    override fun OnMovieItemClicked(position: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("titleMovie", adapter.currentList[position].display_title)
        intent.putExtra("descriptionMovie", adapter.currentList[position].summary_short)
        intent.putExtra("imageMovie", adapter.currentList[position].multimedia.src)
        intent.putExtra("byLine", adapter.currentList[position].byline)
        intent.putExtra("valRating", adapter.currentList[position].publication_date)
        startActivity(intent)
    }


}