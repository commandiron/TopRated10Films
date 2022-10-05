package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.model.WatchListId
import com.commandiron.toprated10films.domain.repository.AppRepository

class RemoveFromWatchList(
    private val repository: AppRepository
) {
    suspend operator fun invoke(watchListId: WatchListId) = repository.deleteWatchListFilm(watchListId)
}