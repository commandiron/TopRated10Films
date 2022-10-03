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
        args = listOf("categoryId", "itemId", "title", "imageUrl"),
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
        itemId: Int = 0,
        title: String? = null,
        imageUrl: String? = null
    ): String {
        return buildString {
            append(route)
            append("?${args[0]}=$categoryId")
            append("?${args[1]}=$itemId")
            append("?${args[2]}=$title")
            append("?${args[3]}=$imageUrl")
        }
    }
}