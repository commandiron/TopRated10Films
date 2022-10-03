package com.commandiron.toprated10films.data.mapper

import com.commandiron.toprated10films.data.model.movie_db_movie_credits.MovieDbCast
import com.commandiron.toprated10films.data.model.movie_db_movie.MovieDbMovie
import com.commandiron.toprated10films.domain.model.Film

fun MovieDbCast.toFilm(): Film {
    return Film(
        id = this.id,
        title = title,
        imageUrl = if(poster_path == null) null else "https://image.tmdb.org/t/p/original/$poster_path",
        vote_average = vote_average,
        vote_count = vote_count
    )
}

fun MovieDbMovie.toFilm(): Film {
    return Film(
        id = id,
        title = title,
        imageUrl = if(poster_path == null) null else "https://image.tmdb.org/t/p/original/$poster_path",
        vote_average = vote_average,
        vote_count = vote_count
    )
}