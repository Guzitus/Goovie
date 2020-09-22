package com.augusto.data.mappers

import com.augusto.domain.model.Link
import com.augusto.domain.model.Movie
import com.augusto.domain.model.Multimedia
import com.augusto.local.entity.MovieEntity

fun Movie.toDomain(): MovieEntity = MovieEntity(
    display_title,
    val_rating,
    critics_pick,
    byline,
    headline,
    summary_short,
    publication_date,
    opening_date,
    date_updated,
    image = multimedia.src ?: "",
    link = link?.url
)

fun MovieEntity.toDomain(): Movie = Movie(
    display_title,
    val_rating ?: "",
    critics_pick,
    byline,
    headline,
    summary_short,
    publication_date,
    opening_date,
    date_updated,
    multimedia = Multimedia(
        src = image,
        width = 0,
        height = 0,
        type = ""
    ),
    link = Link(
        url = link ?: ""
    )
)