package com.commandiron.toprated10films.domain.use_cases

class UseCases(
    val getGenres: GetGenres,
    val filterGenres: FilterGenres,
    val filterYears: FilterYears,
    val getActors: GetActors,
    val getPopulars: GetPopulars
)