package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllWatchListFilms(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): Flow<Response<List<Film>>> = flow {
        repository.getAllWatchListIds().collect { watchListIds ->
            repository.getMoviesByIds(watchListIds.map { it.id }).collect { response ->
                when(response) {
                    is Response.Error -> emit(Response.Error(response.message))
                    Response.Loading -> emit(Response.Loading)
                    is Response.Success -> {
                        val films = response.data
                        val correctedFilms = films.toMutableList().also { mutableFilms ->
                            mutableFilms.map { it.isInWatchList = true }
                        }
                        emit(Response.Success(correctedFilms))
                    }
                }
            }
        }
    }
}