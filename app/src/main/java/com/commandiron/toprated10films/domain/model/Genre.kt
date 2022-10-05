package com.commandiron.toprated10films.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Genre(
    @PrimaryKey
    val id: Int,
    val name: String,
    val imageUrl: String? = null
)