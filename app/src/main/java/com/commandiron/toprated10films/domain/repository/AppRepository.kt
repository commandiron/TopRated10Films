package com.commandiron.toprated10films.domain.repository

import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.ui.model.Actor
import com.commandiron.toprated10films.util.Response
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getGenres(): Flow<Response<List<Genre>>>
    suspend fun saveGenres(genres: List<Genre>)
    suspend fun getActors(page: Int): Flow<Response<List<Actor>>>
}