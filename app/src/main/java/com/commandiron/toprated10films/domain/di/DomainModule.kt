package com.commandiron.toprated10films.domain.di

import com.commandiron.toprated10films.domain.use_cases.FilterGenres
import com.commandiron.toprated10films.domain.use_cases.FilterYears
import com.commandiron.toprated10films.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideUseCases(
    ): UseCases {
        return UseCases(
            filterGenres = FilterGenres(),
            filterYears = FilterYears()
        )
    }
}