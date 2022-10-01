package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.ui.model.Actor
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow

class GetActors(
    private val repository: AppRepository
) {
    suspend operator fun invoke(page: Int): Flow<Response<List<Actor>>> = repository.getActors(page)
}