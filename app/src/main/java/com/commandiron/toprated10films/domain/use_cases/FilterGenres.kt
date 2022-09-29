package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.ui.model.Genre

class FilterGenres {
    operator fun invoke(
        query: String,
        genres: List<Genre>
    ): List<Genre> {
        return genres.filter {
            it.name.contains(query.trim(), ignoreCase = true)
        }
    }
}