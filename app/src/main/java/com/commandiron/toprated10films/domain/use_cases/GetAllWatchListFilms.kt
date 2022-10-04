package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.model.WatchListFilm
import com.commandiron.toprated10films.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class GetAllWatchListFilms(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): Flow<List<WatchListFilm>> = repository.getAllWatchListFilms()
}