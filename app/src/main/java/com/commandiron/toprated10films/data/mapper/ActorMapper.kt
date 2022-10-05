package com.commandiron.toprated10films.data.mapper

import com.commandiron.toprated10films.data.model.movie_db_actor.MovieDbActor
import com.commandiron.toprated10films.domain.model.Actor

fun MovieDbActor.toActor(): Actor {
    return Actor(
        id = id,
        name = name,
        imageUrl = if(profile_path == null) null else "https://image.tmdb.org/t/p/original/$profile_path"
    )
}