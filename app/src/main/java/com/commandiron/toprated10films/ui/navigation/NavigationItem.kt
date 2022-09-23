package com.commandiron.toprated10films.ui.navigation

sealed class NavigationItem(
    val route: String
) {
    object SplashScreen: NavigationItem(
        route = "splash"
    )
    object TopTenScreen: NavigationItem(
        route = "topTen"
    )
    object WatchListScreen: NavigationItem(
        route = "watchList"
    )
}