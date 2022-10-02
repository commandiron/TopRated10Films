package com.commandiron.toprated10films.data.remote

import com.commandiron.toprated10films.data.model.movie_db_actor.MovieDbActorDto
import com.commandiron.toprated10films.data.model.movie_db_genre.MovieDbGenreDto
import com.commandiron.toprated10films.data.model.movie_db_movie_credits.MovieDbCreditsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("genre/movie/list?api_key=ccee772c336daab0b8542a7e371680db")
    suspend fun getGenres(): MovieDbGenreDto

    @GET("person/popular?api_key=ccee772c336daab0b8542a7e371680db")
    suspend fun getPopularActors(
        @Query("page")
        page: Int
    ): MovieDbActorDto

    @GET("search/person?api_key=ccee772c336daab0b8542a7e371680db")
    suspend fun getActorsByQuery(
        @Query("page")
        page: Int,
        @Query("query")
        query: String
    ): MovieDbActorDto

    //Burda sonuç null geliyor.
    @GET("person/{id}/movie_credits?api_key=ccee772c336daab0b8542a7e371680db")
    suspend fun getMoviesByActor(
        @Path("id")
        actorId: Int,
    ): MovieDbCreditsDto

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}