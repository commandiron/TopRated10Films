package com.commandiron.toprated10films.data.remote

import com.commandiron.toprated10films.data.model.movie_db_actor.MovieDbActorDto
import com.commandiron.toprated10films.data.model.movie_db_genre.MovieDbGenreDto
import com.commandiron.toprated10films.data.model.movie_db_credits.MovieDbCreditsDto
import com.commandiron.toprated10films.data.model.movie_db_detail.MovieDbDetailDto
import com.commandiron.toprated10films.data.model.movie_db_movie.MovieDbMovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("genre/movie/list?api_key=$API_KEY")
    suspend fun getGenres(): MovieDbGenreDto

    @GET("person/popular?api_key=$API_KEY")
    suspend fun getPopularActors(
        @Query("page")
        page: Int
    ): MovieDbActorDto

    @GET("search/person?api_key=$API_KEY")
    suspend fun getActorsByQuery(
        @Query("page")
        page: Int,
        @Query("query")
        query: String
    ): MovieDbActorDto

    @GET("person/{id}/movie_credits?api_key=$API_KEY")
    suspend fun getMoviesByActor(
        @Path("id")
        actorId: Int,
    ): MovieDbCreditsDto

    @GET("movie/top_rated?api_key=$API_KEY")
    suspend fun getTopRatedMovies(): MovieDbMovieDto

    @GET("discover/movie?api_key=$API_KEY")
    suspend fun getMoviesByGenre(
        @Query("sort_by")
        sortBy: String = "vote_average.desc",
        @Query("vote_count.gte")
        voteCountGte: Int,
        @Query("with_genres")
        genreId: Int
    ): MovieDbMovieDto

    @GET("discover/movie?api_key=$API_KEY")
    suspend fun getMoviesByYear(
        @Query("sort_by")
        sortBy: String = "vote_average.desc",
        @Query("vote_count.gte")
        voteCountGte: Int,
        @Query("primary_release_year")
        year: Int
    ): MovieDbMovieDto

    @GET("movie/{id}?api_key=$API_KEY")
    suspend fun getMoviesById(
        @Path("id")
        id: Int
    ): MovieDbDetailDto

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "ccee772c336daab0b8542a7e371680db"
    }
}