package com.commandiron.toprated10films.data.model.movie_db_detail

import androidx.annotation.Keep

@Keep
data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)