package com.augusto.local.entity

import androidx.room.Entity
import java.io.Serializable


@Entity
data class MovieEntity(
    val display_title: String,
    val val_rating: String,
    val critics_pick: Int,
    val byline: String,
    val headline: String,
    val summary_short: String,
    val publication_date: String,
    val opening_date: String? = null,
    val date_updated: String,
    val image: String
)

