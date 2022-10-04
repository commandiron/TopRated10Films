package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.model.WatchListId
import com.commandiron.toprated10films.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class GetAllWatchListIds(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): Flow<List<WatchListId>> = repository.getAllWatchListIds()
}