package com.commandiron.toprated10films.ui.navigation

sealed class NavigationItem(
    val route: String,
    val isBottomBarVisible: Boolean
) {
    object SplashScreen: NavigationItem(
        route = "splash",
        isBottomBarVisible = false,
    )
    object WatchListScreen: NavigationItem(
        route = "watchList",
        isBottomBarVisible = true
    )
    object SelectionScreen: NavigationItem(
        route = "selection",
        isBottomBarVisible = true
    )
    object ActorScreen: NavigationItem(
        route = "actor",
        isBottomBarVisible = true
    )
    object GenreScreen: NavigationItem(
        route = "genre",
        isBottomBarVisible = true
    )
    object YearScreen: NavigationItem(
        route = "year",
        isBottomBarVisible = true
    )
    object ShowResultScreen: NavigationItem(
        route = "showResult",
        isBottomBarVisible = true
    )
}