package com.commandiron.toprated10films.data.remote

import com.commandiron.toprated10films.data.model.MovieDbActorDto
import com.commandiron.toprated10films.data.model.MovieDbGenreDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("genre/movie/list?api_key=ccee772c336daab0b8542a7e371680db")
    suspend fun getGenres(): MovieDbGenreDto

    @GET("person/popular?api_key=ccee772c336daab0b8542a7e371680db")
    suspend fun getActors(
        @Query("page")
        page: Int
    ): MovieDbActorDto
}