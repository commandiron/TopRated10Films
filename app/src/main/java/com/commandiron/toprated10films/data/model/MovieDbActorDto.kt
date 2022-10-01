package com.commandiron.toprated10films.data.model

import com.squareup.moshi.Json

data class MovieDbActorDto(
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "results")
    val movieDbActors: List<MovieDbActor>,
    @field:Json(name = "total_pages")
    val total_pages: Int,
    @field:Json(name = "total_results")
    val total_results: Int
)