package com.commandiron.toprated10films.navigation.nav_graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.commandiron.toprated10films.navigation.NavigationItem
import com.commandiron.toprated10films.ui.presentation.splash.SplashScreen
import com.commandiron.toprated10films.ui.presentation.watch_list.WatchListScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNavGraph(
    navController: NavHostController,
    shouldShowSplash: Boolean,
    onImageClick:(expanded: Boolean) -> Unit
) {
    AnimatedNavHost(
        navController = navController,
        route = GraphItem.RootGraph.route,
        startDestination = if(shouldShowSplash) {
            NavigationItem.SplashScreen.route
        } else GraphItem.TopTenGraph.route
    ){
        composable(
            route = NavigationItem.SplashScreen.route,
            enterTransition = {
                when(initialState.destination.route){
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    else -> fadeOut(
                        animationSpec = tween(3000)
                    )
                }
            }
        ){
            SplashScreen{
                navController.popBackStack()
                navController.navigate(GraphItem.TopTenGraph.route)
            }
        }
        topTenNavGraph(
            navController = navController,
            onImageClick = onImageClick
        )
        composable(
            route = NavigationItem.WatchListScreen.route,
            enterTransition = {
                when(initialState.destination.route){
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    else -> null
                }
            }
        ) {
            WatchListScreen()
        }
    }
}