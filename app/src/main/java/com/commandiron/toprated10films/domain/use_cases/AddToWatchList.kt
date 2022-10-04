package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.model.WatchListFilm
import com.commandiron.toprated10films.domain.repository.AppRepository

class AddToWatchList(
    private val repository: AppRepository
) {
    suspend operator fun invoke(watchListFilm: WatchListFilm) = repository.insertWatchListFilm(watchListFilm)
}