package com.commandiron.toprated10films.navigation

sealed class NavigationItem(
    val route: String,
    val args: List<String> = listOf(),
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
        args = listOf("categoryId", "title", "imageUrl", "actorId", "genreId", "year"),
        isBottomBarVisible = true
    )

    fun routeWithArgs(): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("?$arg={$arg}")
            }
        }
    }

    fun addArgs(
        categoryId: Int = 0,
        title: String? = null,
        imageUrl: String? = null,
        actorId: Int = 0,
        genreId: Int = 0,
        year: Int = 0
    ): String {
        return buildString {
            append(route)
            append("?${args[0]}=$categoryId")
            append("?${args[1]}=$title")
            append("?${args[2]}=$imageUrl")
            append("?${args[3]}=$actorId")
            append("?${args[4]}=$genreId")
            append("?${args[5]}=$year")
        }
    }
}