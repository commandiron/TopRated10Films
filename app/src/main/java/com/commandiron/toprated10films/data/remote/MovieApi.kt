package com.commandiron.toprated10films.data.remote

import com.commandiron.toprated10films.data.model.MovieDbGenreDto
import retrofit2.http.GET

interface MovieApi {

    @GET("genre/movie/list?api_key=ccee772c336daab0b8542a7e371680db")
    suspend fun getGenres(): MovieDbGenreDto
}