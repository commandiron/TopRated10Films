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
                            categoryId = Category.AllTime.id,
                            title = Category.AllTime.title,
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
                onPopularItemClick = { categoryId, itemId, title, imageUrl ->
                    navController.navigate(
                        NavigationItem.ShowResultScreen.addArgs(
                            categoryId = categoryId,
                            itemId = itemId,
                            title = title,
                            imageUrl = imageUrl
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
            ActorScreen { actorId, actorName, imageUrl ->
                navController.navigate(
                    NavigationItem.ShowResultScreen.addArgs(
                        categoryId = Category.ByActor.id,
                        itemId = actorId,
                        title = actorName,
                        imageUrl = imageUrl
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
            GenreScreen { genreId, genreName, imageUrl ->
                navController.navigate(
                    NavigationItem.ShowResultScreen.addArgs(
                        categoryId = Category.ByGenre.id,
                        itemId = genreId,
                        title = genreName,
                        imageUrl = imageUrl
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
            YearScreen { yearName ->
                navController.navigate(
                    NavigationItem.ShowResultScreen.addArgs(
                        categoryId = Category.ByYear.id,
                        title = yearName
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
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(NavigationItem.ShowResultScreen.args[2]) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument(NavigationItem.ShowResultScreen.args[3]) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
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