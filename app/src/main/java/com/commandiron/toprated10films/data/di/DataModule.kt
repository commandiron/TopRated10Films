package com.commandiron.toprated10films.data.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.commandiron.toprated10films.data.local.AppDao
import com.commandiron.toprated10films.data.local.AppDatabase
import com.commandiron.toprated10films.data.local.AppDatabase.Companion.DATABASE_NAME
import com.commandiron.toprated10films.data.local.DefaultPreferences
import com.commandiron.toprated10films.data.local.DefaultPreferences.Companion.PREF_NAME
import com.commandiron.toprated10films.data.remote.MovieApi
import com.commandiron.toprated10films.data.remote.MovieApi.Companion.BASE_URL
import com.commandiron.toprated10films.data.repository.AppRepositoryImpl
import com.commandiron.toprated10films.domain.preferences.AppPreferences
import com.commandiron.toprated10films.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): AppPreferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(
        okHttpClient: OkHttpClient
    ): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
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