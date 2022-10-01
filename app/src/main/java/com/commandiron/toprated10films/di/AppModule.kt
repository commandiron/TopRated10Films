package com.commandiron.toprated10films.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.commandiron.toprated10films.data.local.DefaultPreferences
import com.commandiron.toprated10films.domain.preferences.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): AppPreferences {
        return DefaultPreferences(sharedPreferences)
    }
}