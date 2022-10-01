package com.commandiron.toprated10films.data.repository

import com.commandiron.toprated10films.data.local.AppDao
import com.commandiron.toprated10films.data.mapper.toActor
import com.commandiron.toprated10films.data.mapper.toGenre
import com.commandiron.toprated10films.data.remote.MovieApi
import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.ui.model.Actor
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AppRepositoryImpl(
    private val api: MovieApi,
    private val dao: AppDao
): AppRepository {
    override suspend fun getGenres(): Flow<Response<List<Genre>>> = flow {
        emit(Response.Loading)
        var genres: List<Genre> = dao.getAllGenres()
        if(genres.isNotEmpty()) {
            emit(Response.Success(genres))
        }else {
            try {
                genres = api.getGenres().movieDbGenreData.map { it.toGenre() }
                emit(Response.Success(genres))
                saveGenres(genres)
            }catch (e: Exception) {
                emit(Response.Error(e.message ?: "AN_ERROR_OCCURRED"))
                e.printStackTrace()
            }
        }
    }

    override suspend fun saveGenres(genres: List<Genre>) {
        dao.insertGenre(*genres.toTypedArray())
    }

    override suspend fun getActors(page: Int): Flow<Response<List<Actor>>> = flow {
        emit(Response.Loading)
        try {
            val actors: List<Actor> = api.getActors(page).movieDbActors.map { it.toActor() }
            emit(Response.Success(actors))
        }catch (e: Exception) {
            emit(Response.Error(e.message ?: "AN_ERROR_OCCURRED"))
            e.printStackTrace()
        }
    }
}