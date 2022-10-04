package com.commandiron.toprated10films.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WatchListFilm(
    @PrimaryKey
    val id: Int
)