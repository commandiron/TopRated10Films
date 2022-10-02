package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.ui.model.Film
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow

class GetTopTenFilmsByActor(
    private val repository: AppRepository
) {
    suspend operator fun invoke(actorId: Int): Flow<Response<List<Film>>> = repository.getMoviesByActor(actorId)
}