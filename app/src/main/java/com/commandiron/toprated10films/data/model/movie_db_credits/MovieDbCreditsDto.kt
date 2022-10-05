package com.commandiron.toprated10films.data.model.movie_db_credits

import androidx.annotation.Keep

@Keep
data class MovieDbCreditsDto(
    val cast: List<MovieDbCast>,
    val crew: List<MovieDbCrew>,
    val id: Int
)