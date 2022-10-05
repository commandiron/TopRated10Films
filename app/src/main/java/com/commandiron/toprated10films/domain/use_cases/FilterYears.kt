package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.ui.model.Year

class FilterYears {
    operator fun invoke(
        query: String,
        years: List<Year>
    ): List<Year> {
        return years.filter {
            it.name.contains(query.trim(), ignoreCase = true)
        }
    }
}