package com.commandiron.toprated10films.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.domain.model.WatchListId

@Database(
    entities = [Genre::class, WatchListId::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase(){
    abstract val dao: AppDao

    companion object {
        const val DATABASE_NAME = "app_db"
    }
}