package com.augusto.goovies.features

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.augusto.goovies.R
import com.augusto.goovies.extensions.loadImageCoil
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.android.scope.currentScope

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    val arguments: MovieDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(arguments.movie) {
            textDetailTitle.text = display_title
            textDescriptionDetail.text = summary_short
            val remoteMedia = multimedia.src
            imageDetail.loadImageCoil {
                uri = remoteMedia
            }
            textByLine.text = byline
            textLink.text = publication_date
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.anv_share -> shareMovie()
        }

        return super.onOptionsItemSelected(item)
    }

    fun shareMovie() {
        activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setType("text/plain")
                .setChooserTitle("Compartilhar filme")
                .setText(arguments.movie.link?.url)
                .startChooser()
        }
    }

}