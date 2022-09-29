package com.commandiron.toprated10films.navigation

sealed class NavigationItem(
    val route: String,
    val argNames: List<String> = listOf(),
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
        argNames = listOf("categoryId", "query"),
        isBottomBarVisible = true
    )

    fun routeWithArgNames(): String {
        return buildString {
            append(route)
            argNames.forEach { argName ->
                append("?$argName={$argName}")
            }
        }
    }

    fun addArgs(categoryIdArg: Int? = null, queryArg: String? = null): String {
        return buildString {
            append(route)
            append("?${argNames[0]}=$categoryIdArg")
            append("?${argNames[1]}=$queryArg")
        }
    }
}