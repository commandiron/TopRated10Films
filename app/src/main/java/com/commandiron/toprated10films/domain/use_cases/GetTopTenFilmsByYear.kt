package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTopTenFilmsByYear(
    private val repository: AppRepository
) {
    suspend operator fun invoke(year: Int): Flow<Response<List<Film>>> = flow {
        var flagForSufficientListSize = false
        var voteCountGte = 20000
        while (!flagForSufficientListSize) {
            repository.getMoviesByYear(voteCountGte = voteCountGte, year = year).collect { response ->
                when(response) {
                    is Response.Error -> emit(Response.Error(response.message))
                    Response.Loading -> emit(Response.Loading)
                    is Response.Success -> {
                        if(response.data.size >= 10) {
                            emit(Response.Success(response.data.take(10)))
                            flagForSufficientListSize = true
                        }else {
                            voteCountGte -= 500
                        }
                    }
                }
            }
        }
    }
}