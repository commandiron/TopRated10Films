package com.commandiron.toprated10films.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.commandiron.toprated10films.ui.presentation.actor.ActorScreen
import com.commandiron.toprated10films.ui.presentation.genre.GenreScreen
import com.commandiron.toprated10films.ui.presentation.selection.SelectionScreen
import com.commandiron.toprated10films.ui.presentation.show_result.ShowResultScreen
import com.commandiron.toprated10films.ui.presentation.year.YearScreen

fun NavGraphBuilder.topTenNavGraph(navController: NavHostController) {
    navigation(
        route = NavigationItem.TopTenGraph.route,
        startDestination = NavigationItem.SelectionScreen.route
    ) {
        composable(NavigationItem.SelectionScreen.route) {
            SelectionScreen()
        }
        composable(NavigationItem.ActorScreen.route) {
            ActorScreen()
        }
        composable(NavigationItem.GenreScreen.route) {
            GenreScreen()
        }
        composable(NavigationItem.YearScreen.route) {
            YearScreen()
        }
        composable(NavigationItem.ShowResultScreen.route) {
            ShowResultScreen()
        }
    }
}