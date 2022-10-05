package com.commandiron.toprated10films.data.model.movie_db_detail

import androidx.annotation.Keep

@Keep
data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)