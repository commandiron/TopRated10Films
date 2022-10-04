package com.commandiron.toprated10films.domain.use_cases

class UseCases(
    val getGenres: GetGenres,
    val filterGenres: FilterGenres,
    val filterYears: FilterYears,
    val getActors: GetActors,
    val getPopulars: GetPopulars,
    val getTopTenFilmsByActor: GetTopTenFilmsByActor,
    val getTopTenFilmsByAllTime: GetTopTenFilmsByAllTime,
    val getTopTenFilmsByGenre: GetTopTenFilmsByGenre,
    val getTopTenFilmsByYear: GetTopTenFilmsByYear,
    val addToWatchList: AddToWatchList,
    val removeFromWatchList: RemoveFromWatchList,
    val getAllWatchListFilms: GetAllWatchListFilms
)