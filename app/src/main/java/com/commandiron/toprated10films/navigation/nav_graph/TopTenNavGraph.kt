package com.commandiron.toprated10films.navigation.nav_graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.commandiron.toprated10films.navigation.NavigationItem
import com.commandiron.toprated10films.ui.model.Category
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
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    else -> null
                }
            }
        ) {
            SelectionScreen(
                onAllTimeClick = {
                    navController.navigate(
                        NavigationItem.ShowResultScreen.addArgs(
                            categoryIdArg = Category.AllTime.id,
                            queryArg = Category.AllTime.title,
                            imageUrl = Category.AllTime.imageUrl
                        )
                    )
                },
                onActorClick = {
                    navController.navigate(NavigationItem.ActorScreen.route)
                },
                onGenreClick = {
                    navController.navigate(NavigationItem.GenreScreen.route)
                },
                onYearClick = {
                    navController.navigate(NavigationItem.YearScreen.route)
                },
                onPopularItemClick = { categoryId, query, imageUrl, id, year ->
                    navController.navigate(
                        NavigationItem.ShowResultScreen.addArgs(
                            categoryIdArg = categoryId,
                            queryArg = query,
                            imageUrl = imageUrl,
                            actorId = id ?: 0,
                            genreId = id ?: 0,
                            year = year ?: 0
                        )
                    )
                }
            )
        }
        composable(
            route = NavigationItem.ActorScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    else -> null
                }
            }
        ) {
            ActorScreen { actorName, imageUrl, actorId ->
                navController.navigate(
                    NavigationItem.ShowResultScreen.addArgs(
                        categoryIdArg = Category.ByActor.id,
                        queryArg = actorName,
                        imageUrl = imageUrl,
                        actorId = actorId
                    )
                )
            }
        }
        composable(
            route = NavigationItem.GenreScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    else -> null
                }
            }
        ) {
            GenreScreen { genreName, imageUrl, genreId ->
                navController.navigate(
                    NavigationItem.ShowResultScreen.addArgs(
                        categoryIdArg = Category.ByGenre.id,
                        queryArg = genreName,
                        imageUrl = imageUrl,
                        genreId = genreId
                    )
                )
            }
        }
        composable(
            route = NavigationItem.YearScreen.route,
            enterTransition = {
                when(initialState.destination.route) {
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    else -> null
                }
            }
        ) {
            YearScreen { year ->
                navController.navigate(
                    NavigationItem.ShowResultScreen.addArgs(
                        categoryIdArg = Category.ByYear.id,
                        queryArg = year,
                        year = year.toInt()
                    )
                )
            }
        }
        composable(
            route = NavigationItem.ShowResultScreen.routeWithArgs(),
            arguments = listOf(
                navArgument(NavigationItem.ShowResultScreen.args[0]) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(NavigationItem.ShowResultScreen.args[1]) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument(NavigationItem.ShowResultScreen.args[2]) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument(NavigationItem.ShowResultScreen.args[3]) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(NavigationItem.ShowResultScreen.args[4]) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(NavigationItem.ShowResultScreen.args[5]) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            ),
            enterTransition = {
                when(initialState.destination.route) {
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    else -> null
                }
            }
        ) {
            ShowResultScreen()
        }
    }
}