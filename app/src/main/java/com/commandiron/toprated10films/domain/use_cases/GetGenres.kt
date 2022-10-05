package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow

class GetGenres(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): Flow<Response<List<Genre>>> = repository.getGenres()
}