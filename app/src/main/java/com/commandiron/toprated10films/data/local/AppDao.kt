package com.commandiron.toprated10films.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.commandiron.toprated10films.domain.model.Genre

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenre(vararg genre: Genre)

    @Query("SELECT * FROM genre")
    suspend fun getAllGenres(): List<Genre>
}