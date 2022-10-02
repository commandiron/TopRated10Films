package com.commandiron.toprated10films.data.di

import android.content.Context
import androidx.room.Room
import com.commandiron.toprated10films.data.local.AppDao
import com.commandiron.toprated10films.data.local.AppDatabase
import com.commandiron.toprated10films.data.local.AppDatabase.Companion.DATABASE_NAME
import com.commandiron.toprated10films.data.remote.MovieApi
import com.commandiron.toprated10films.data.remote.MovieApi.Companion.BASE_URL
import com.commandiron.toprated10films.data.repository.AppRepositoryImpl
import com.commandiron.toprated10films.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideAppDao(database: AppDatabase) = database.dao

    @Provides
    @Singleton
    fun provideAppRepository(
        api: MovieApi,
        dao: AppDao
    ): AppRepository {
        return AppRepositoryImpl(
            api = api,
            dao = dao
        )
    }
}