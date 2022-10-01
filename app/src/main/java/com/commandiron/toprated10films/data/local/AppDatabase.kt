package com.commandiron.toprated10films.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.commandiron.toprated10films.domain.model.Genre

@Database(
    entities = [Genre::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase(){
    abstract val dao: AppDao
}