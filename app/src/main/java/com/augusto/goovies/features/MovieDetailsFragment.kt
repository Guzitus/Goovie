package com.augusto.goovies.features

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.augusto.goovies.R
import com.augusto.goovies.extensions.loadImageCoil
import kotlinx.android.synthetic.main.fragment_movie_details.*

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
            textLink.text = val_rating
        }
    }
}