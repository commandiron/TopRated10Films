package com.commandiron.toprated10films.data.model.movie_db_movie

data class MovieDbMovieDto(
    val page: Int,
    val results: List<MovieDbMovie>,
    val total_pages: Int,
    val total_results: Int
)