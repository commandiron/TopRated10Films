package com.commandiron.toprated10films.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.commandiron.toprated10films.domain.preferences.AppPreferences


@Composable
fun rememberAppState(
    preferences: AppPreferences,
    windowSizeClass: WindowSizeClass,
    navController: NavHostController,
): AppState {
    return remember {
        AppState(preferences, windowSizeClass, navController)
    }
}

class AppState(
    preferences: AppPreferences,
    private val windowSizeClass: WindowSizeClass,
    private val navController: NavHostController,
) {
    val currentRoute: String?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route

    val currentWindowWidthSizeClass : WindowWidthSizeClass
        get() = getWindowWidthSizeClass()

    val currentWindowHeightSizeClass : WindowHeightSizeClass
        get() = getWindowHeightSizeClass()

    private fun getWindowWidthSizeClass(): WindowWidthSizeClass {
        return windowSizeClass.widthSizeClass
    }

    private fun getWindowHeightSizeClass(): WindowHeightSizeClass {
        return windowSizeClass.heightSizeClass
    }

    var isBottomNavBarVisible by mutableStateOf(true)
        private set

    var shouldShowSplash by mutableStateOf(preferences.loadShouldShowSplash())
        private set

    fun setBottomBarVisibility(visible: Boolean) {
        isBottomNavBarVisible = visible
    }

    fun bottomNavigate(route: String) {
        navController.popBackStack()
        navController.navigate(route) {
            navController.graph.startDestinationRoute?.let { screen_route ->
                popUpTo(screen_route) {
                    saveState = true
                }
            }
        }
    }
}