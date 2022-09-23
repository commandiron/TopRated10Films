package com.commandiron.toprated10films.ui.navigation

sealed class NavigationItem(
    val route: String
) {
    object SplashScreen: NavigationItem(
        route = "splash"
    )
    object WatchListScreen: NavigationItem(
        route = "watchList"
    )
    object SelectionScreen: NavigationItem(
        route = "selection"
    )
    object ActorScreen: NavigationItem(
        route = "actor"
    )
    object GenreScreen: NavigationItem(
        route = "genre"
    )
    object YearScreen: NavigationItem(
        route = "year"
    )
    object ShowResultScreen: NavigationItem(
        route = "showResult"
    )
    object RootGraph: NavigationItem(
        route = "root"
    )
    object TopTenGraph: NavigationItem(
        route = "topTen"
    )
}