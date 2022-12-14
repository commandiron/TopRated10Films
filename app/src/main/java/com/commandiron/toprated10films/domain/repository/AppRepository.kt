package com.commandiron.toprated10films.domain.repository

import androidx.paging.PagingData
import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.domain.model.Actor
import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.domain.model.WatchListId
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getGenres(): Flow<Response<List<Genre>>>
    suspend fun saveGenres(genres: List<Genre>)
    suspend fun getActors(query: String): Flow<PagingData<Actor>>
    suspend fun getMoviesByActor(actorId: Int): Flow<Response<List<Film>>>
    suspend fun getTopRatedMovies(): Flow<Response<List<Film>>>
    suspend fun getMoviesByGenre(voteCountGte: Int, genreId: Int): Flow<Response<List<Film>>>
    suspend fun getMoviesByYear(voteCountGte: Int, year: Int): Flow<Response<List<Film>>>
    suspend fun getMoviesByIds(ids: List<Int>): Flow<Response<List<Film>>>
    suspend fun insertWatchListFilm(watchListId: WatchListId): Flow<Response<Unit>>
    suspend fun deleteWatchListFilm(watchListId: WatchListId): Flow<Response<Unit>>
    suspend fun getAllWatchListIds(): Flow<List<WatchListId>>
}