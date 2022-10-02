package com.commandiron.toprated10films.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.commandiron.toprated10films.data.local.AppDao
import com.commandiron.toprated10films.data.mapper.toFilm
import com.commandiron.toprated10films.data.mapper.toGenre
import com.commandiron.toprated10films.data.paging.ActorPagingSource
import com.commandiron.toprated10films.data.remote.MovieApi
import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.domain.model.Actor
import com.commandiron.toprated10films.ui.model.Film
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

    override suspend fun getActors(query: String): Flow<PagingData<Actor>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { ActorPagingSource(api = api, query = query) }
        ).flow
    }

    override suspend fun getMoviesByActor(actorId: Int): Flow<Response<List<Film>>> = flow {
        emit(Response.Loading)
        try {
            val films = api.getMoviesByActor(actorId).cast.map { it.toFilm() }
            emit(Response.Success(films))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: "AN_ERROR_OCCURRED"))
            e.printStackTrace()
        }
    }
}