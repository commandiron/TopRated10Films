package com.commandiron.toprated10films.data.model.movie_db_top_rated

data class MovieDbTopRatedDto(
    val page: Int,
    val results: List<MovieDbFilm>,
    val total_pages: Int,
    val total_results: Int
)