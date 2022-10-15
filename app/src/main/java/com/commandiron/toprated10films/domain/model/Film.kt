package com.commandiron.toprated10films.domain.model

data class Film(
    val id: Int,
    val title: String,
    val imageUrl: String?,
    val overview: String,
    val releaseYear: String,
    val vote_average: Double,
    val vote_count: Int,
    var isInWatchList: Boolean = false
)
