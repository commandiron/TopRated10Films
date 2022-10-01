package com.commandiron.toprated10films.data.mapper

import com.commandiron.toprated10films.data.model.MovieDbGenre
import com.commandiron.toprated10films.domain.model.Genre

fun MovieDbGenre.toGenre(): Genre {
    return Genre(
        name = name
    )
}