package com.commandiron.toprated10films.data.model.movie_db_detail

import androidx.annotation.Keep

@Keep
data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)