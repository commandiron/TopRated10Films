package com.commandiron.toprated10films.data.mapper

import com.commandiron.toprated10films.data.model.MovieDbActor
import com.commandiron.toprated10films.ui.model.Actor

fun MovieDbActor.toActor(): Actor {
    return Actor(
        name = name,
        imageUrl = "https://image.tmdb.org/t/p/original/$profile_path"
    )
}