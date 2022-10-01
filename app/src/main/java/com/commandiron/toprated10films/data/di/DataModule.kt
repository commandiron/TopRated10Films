package com.commandiron.toprated10films.data.di

import com.commandiron.toprated10films.data.remote.MovieApi
import com.commandiron.toprated10films.data.repository.AppRepositoryImpl
import com.commandiron.toprated10films.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideAppRepository(
        api: MovieApi
    ): AppRepository {
        return AppRepositoryImpl(
            api = api
        )
    }
}