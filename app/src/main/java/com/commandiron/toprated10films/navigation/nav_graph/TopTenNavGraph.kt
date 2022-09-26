package com.commandiron.toprated10films.navigation.nav_graph

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.commandiron.toprated10films.navigation.NavigationItem
import com.commandiron.toprated10films.ui.presentation.actor.ActorScreen
import com.commandiron.toprated10films.ui.presentation.genre.GenreScreen
import com.commandiron.toprated10films.ui.presentation.selection.SelectionScreen
import com.commandiron.toprated10films.ui.presentation.show_result.ShowResultScreen
import com.commandiron.toprated10films.ui.presentation.year.YearScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.topTenNavGraph(
    navController: NavHostController
) {
    navigation(
        route = GraphItem.TopTenGraph.route,
        startDestination = NavigationItem.SelectionScreen.route,
        enterTransition = {
            when(initialState.destination.route){
                NavigationItem.SplashScreen.route -> fadeIn(
                    animationSpec = tween(
                        durationMillis = 1000,
                        delayMillis = 3000
                    )
                )
                else ->  null
            }
        }
    ) {
        composable(
            route = NavigationItem.SelectionScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    NavigationItem.ActorScreen.route,
                    NavigationItem.GenreScreen.route,
                    NavigationItem.YearScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    NavigationItem.ActorScreen.route,
                    NavigationItem.GenreScreen.route,
                    NavigationItem.YearScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            }
        ) {
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
        composable(
            route = NavigationItem.ActorScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    NavigationItem.SelectionScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    NavigationItem.ShowResultScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    NavigationItem.SelectionScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    NavigationItem.ShowResultScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            }
        ) {
            ActorScreen {
                navController.navigate(NavigationItem.ShowResultScreen.route)
            }
        }
        composable(
            route = NavigationItem.GenreScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    NavigationItem.SelectionScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    NavigationItem.ShowResultScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    NavigationItem.SelectionScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    NavigationItem.ShowResultScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            }
        ) {
            GenreScreen {
                navController.navigate(NavigationItem.ShowResultScreen.route)
            }
        }
        composable(
            route = NavigationItem.YearScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    NavigationItem.SelectionScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    NavigationItem.ShowResultScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    NavigationItem.SelectionScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    NavigationItem.ShowResultScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            }
        ) {
            YearScreen{
                navController.navigate(NavigationItem.ShowResultScreen.route)
            }
        }
        composable(
            route = NavigationItem.ShowResultScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    NavigationItem.ActorScreen.route,
                    NavigationItem.GenreScreen.route,
                    NavigationItem.YearScreen.route -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    NavigationItem.ActorScreen.route,
                    NavigationItem.GenreScreen.route,
                    NavigationItem.YearScreen.route -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                    else -> null
                }
            }
        ) {
            ShowResultScreen()
        }
    }
}