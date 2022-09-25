package com.commandiron.toprated10films.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.commandiron.toprated10films.navigation.NavigationItem
import com.commandiron.toprated10films.ui.presentation.actor.ActorScreen
import com.commandiron.toprated10films.ui.presentation.genre.GenreScreen
import com.commandiron.toprated10films.ui.presentation.selection.SelectionScreen
import com.commandiron.toprated10films.ui.presentation.show_result.ShowResultScreen
import com.commandiron.toprated10films.ui.presentation.year.YearScreen

fun NavGraphBuilder.topTenNavGraph(navController: NavHostController) {
    navigation(
        route = GraphItem.TopTenGraph.route,
        startDestination = NavigationItem.SelectionScreen.route
    ) {
        composable(NavigationItem.SelectionScreen.route) {
            SelectionScreen(
                onClick1 = {
                    navController.navigate(NavigationItem.ActorScreen.route)
                },
                onClick2 = {
                    navController.navigate(NavigationItem.GenreScreen.route)
                },
                onClick3 = {
                    navController.navigate(NavigationItem.YearScreen.route)
                },
            )
        }
        composable(NavigationItem.ActorScreen.route) {
            ActorScreen {
                navController.navigate(NavigationItem.ShowResultScreen.route)
            }
        }
        composable(NavigationItem.GenreScreen.route) {
            GenreScreen {
                navController.navigate(NavigationItem.ShowResultScreen.route)
            }
        }
        composable(NavigationItem.YearScreen.route) {
            YearScreen{
                navController.navigate(NavigationItem.ShowResultScreen.route)
            }
        }
        composable(NavigationItem.ShowResultScreen.route) {
            ShowResultScreen()
        }
    }
}