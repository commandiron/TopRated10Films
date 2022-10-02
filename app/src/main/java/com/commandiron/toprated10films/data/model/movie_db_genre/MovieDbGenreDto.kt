package com.commandiron.toprated10films.data.model.movie_db_genre

import com.squareup.moshi.Json

data class MovieDbGenreDto(
    @field:Json(name = "genres")
    val movieDbGenreData: List<MovieDbGenre>
)