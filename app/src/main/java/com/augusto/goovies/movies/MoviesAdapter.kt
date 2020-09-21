package com.augusto.goovies.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.augusto.goovies.R
import com.augusto.goovies.extensions.loadImageCoil
import com.augusto.domain.model.Movie

class MoviesAdapter(private val onMoviesClickListener: OnMoviesClickListener) : ListAdapter<Movie, MoviesAdapter.MovieViewHolder>(MovieDIFFUTILS) {


    class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textTitle by lazy {
            view.findViewById<TextView>(R.id.textTitle)
        }
        val updateDate by lazy {
            view.findViewById<TextView>(R.id.textUpdateDate)
        }
        val headLine by lazy {
            view.findViewById<TextView>(R.id.textHeadLine)
        }
        val byLine by lazy {
            view.findViewById<TextView>(R.id.byLine)
        }
        val imageMovie by lazy {
            view.findViewById<ImageView>(R.id.imageView)
        }

        fun bind(movie: Movie) {
            textTitle.text = movie.display_title
            updateDate.text = movie.date_updated
            headLine.text = movie.headline
            byLine.text = movie.byline
            movie.multimedia.src?.let{
                imageMovie.loadImageCoil {
                    corners = true
                    uri = movie.multimedia.src
                    cornersRadius = 12f
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onMoviesClickListener.OnMovieItemClicked(position)
        }
    }


}

object MovieDIFFUTILS : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.display_title == newItem.display_title

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.display_title == newItem.display_title &&
                oldItem.byline == newItem.byline &&
                oldItem.critics_pick == newItem.critics_pick &&
                oldItem.date_updated == newItem.date_updated &&
                oldItem.headline == newItem.headline &&
                oldItem.link == newItem.link &&
                oldItem.multimedia == newItem.multimedia &&
                oldItem.opening_date == newItem.opening_date &&
                oldItem.publication_date == newItem.publication_date &&
                oldItem.summary_short == newItem.summary_short &&
                oldItem.val_rating == newItem.val_rating

}