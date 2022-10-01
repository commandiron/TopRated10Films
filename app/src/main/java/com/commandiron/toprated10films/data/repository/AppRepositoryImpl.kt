package com.commandiron.toprated10films.data.repository

import com.commandiron.toprated10films.data.mapper.toGenre
import com.commandiron.toprated10films.data.remote.MovieApi
import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AppRepositoryImpl(
    private val api: MovieApi,
): AppRepository {
    override suspend fun getGenres(): Flow<Response<List<Genre>>> = flow {
        emit(Response.Loading)
        try {
            val genres = api.getGenres().movieDbGenreData.map { it.toGenre() }
            emit(Response.Success(genres))
        }catch (e: Exception) {
            emit(Response.Error(e.message ?: "AN_ERROR_OCCURRED"))
            e.printStackTrace()
        }
    }
}