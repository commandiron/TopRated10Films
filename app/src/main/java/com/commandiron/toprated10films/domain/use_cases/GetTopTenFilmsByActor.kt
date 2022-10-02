package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.ui.model.Film
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTopTenFilmsByActor(
    private val repository: AppRepository
) {
    suspend operator fun invoke(actorId: Int): Flow<Response<List<Film>>> = flow {
        repository.getMoviesByActor(actorId).collect { response ->
            when(response) {
                is Response.Error -> emit(Response.Error(response.message))
                Response.Loading -> emit(Response.Loading)
                is Response.Success -> {
                    val moviesByActor = response.data
                    var result = moviesByActor
                        .filter { it.vote_count > 100 }
                        .sortedByDescending { it.vote_average }
                        .take(10)

                    if(result.isEmpty()) {
                        result = moviesByActor
                            .sortedByDescending { it.vote_average }
                            .take(10)
                    }

                    emit(Response.Success(result))
                }
            }
        }
    }
}