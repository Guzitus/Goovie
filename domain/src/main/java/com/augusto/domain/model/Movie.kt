package com.augusto.domain.model

import java.io.Serializable

data class Movie(
    val display_title: String,
    val val_rating: String,
    val critics_pick: Int,
    val byline: String,
    val headline: String,
    val summary_short: String,
    val publication_date: String,
    val opening_date: String? = null,
    val date_updated: String,
    val link: Link?,
    val multimedia: Multimedia
) : Serializable

data class Link(val type: String = "", val url: String, val suggested_link_text: String = "")
data class Multimedia(val type: String, val src: String? = null, val width: Int, val height: Int)


