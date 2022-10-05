package com.commandiron.toprated10films.data.model.movie_db_detail

import androidx.annotation.Keep

@Keep
data class ProductionCompany(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
)