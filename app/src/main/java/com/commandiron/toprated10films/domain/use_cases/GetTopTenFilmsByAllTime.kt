package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTopTenFilmsByAllTime(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): Flow<Response<List<Film>>> = flow {
        repository.getTopRatedMovies().collect { response ->
            when(response) {
                is Response.Error -> emit(Response.Error(response.message))
                Response.Loading -> emit(Response.Loading)
                is Response.Success -> {
                    emit(Response.Success(response.data.take(10)))
                }
            }
        }
    }
}