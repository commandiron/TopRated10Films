package com.commandiron.toprated10films.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.commandiron.toprated10films.ui.presentation.splash.SplashScreen
import com.commandiron.toprated10films.ui.presentation.watch_list.WatchListScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = NavigationItem.RootGraph.route,
        startDestination = NavigationItem.SplashScreen.route,
    ){
        composable(NavigationItem.SplashScreen.route){
            SplashScreen{
                navController.navigate(NavigationItem.TopTenGraph.route)
            }
        }
        topTenNavGraph(navController)
        composable(NavigationItem.WatchListScreen.route) {
            WatchListScreen()
        }
    }
}