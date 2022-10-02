package com.commandiron.toprated10films.data.model.movie_db_movie_credits

data class MovieDbCreditsDto(
    val cast: List<MovieDbCast>,
    val crew: List<MovieDbCrew>,
    val id: Int
)