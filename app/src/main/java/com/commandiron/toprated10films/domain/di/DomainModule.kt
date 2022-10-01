package com.commandiron.toprated10films.domain.di

import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.domain.use_cases.FilterGenres
import com.commandiron.toprated10films.domain.use_cases.FilterYears
import com.commandiron.toprated10films.domain.use_cases.GetGenres
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
        repository: AppRepository
    ): UseCases {
        return UseCases(
            getGenres = GetGenres(repository),
            filterGenres = FilterGenres(),
            filterYears = FilterYears()
        )
    }
}