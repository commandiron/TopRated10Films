package com.commandiron.toprated10films.domain.use_cases

import androidx.paging.PagingData
import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.domain.model.Actor
import kotlinx.coroutines.flow.Flow

class GetActors(
    private val repository: AppRepository
) {
    suspend operator fun invoke(query: String): Flow<PagingData<Actor>> = repository.getActors(query)
}