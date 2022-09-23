package com.commandiron.toprated10films.ui.navigation.nav_graph

sealed class GraphItem(
    val route: String
) {
    object RootGraph: GraphItem(
        route = "root"
    )
    object TopTenGraph: GraphItem(
        route = "topTen"
    )
}