package com.commandiron.toprated10films.data.model.movie_db_movie_credits

data class MovieDbCreditsDto(
    val movieDbCast: List<MovieDbCast>,
    val movieDbCrew: List<MovieDbCrew>,
    val id: Int
)