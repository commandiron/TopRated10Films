package com.commandiron.toprated10films.domain.di

import com.commandiron.toprated10films.domain.repository.AppRepository
import com.commandiron.toprated10films.domain.use_cases.*
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
            filterYears = FilterYears(),
            getActors = GetActors(repository),
            getPopulars = GetPopulars(),
            getTopTenFilmsByActor = GetTopTenFilmsByActor(repository),
            getTopTenFilmsByAllTime = GetTopTenFilmsByAllTime(repository),
            getTopTenFilmsByGenre = GetTopTenFilmsByGenre(repository),
            getTopTenFilmsByYear = GetTopTenFilmsByYear(repository),
            addToWatchList = AddToWatchList(repository),
            removeFromWatchList = RemoveFromWatchList(repository),
            getAllWatchListIds = GetAllWatchListIds(repository),
            getAllWatchListFilms = GetAllWatchListFilms(repository)
        )
    }
}