package com.commandiron.toprated10films.data.model.movie_db_actor

import androidx.annotation.Keep

@Keep
data class MovieDbActor(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<MovieDbActorKnownFor>,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String?
)