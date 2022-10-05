package com.commandiron.toprated10films.data.model.movie_db_genre

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class MovieDbGenreDto(
    @field:Json(name = "genres")
    val movieDbGenreData: List<MovieDbGenre>
)