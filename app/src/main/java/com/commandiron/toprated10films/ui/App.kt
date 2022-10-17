package com.commandiron.toprated10films.ui

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavHostController
import com.commandiron.toprated10films.domain.preferences.AppPreferences
import com.commandiron.toprated10films.navigation.BottomNavigation
import com.commandiron.toprated10films.navigation.nav_graph.RootNavGraph
import com.commandiron.toprated10films.ui.theme.*
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App(
    preferences: AppPreferences,
    windowSizeClass: WindowSizeClass
) {
    val navController: NavHostController = rememberAnimatedNavController()

    val appState = rememberAppState(
        preferences,
        windowSizeClass,
        navController
    )

    val systemUiController = rememberSystemUiController()

    TopRated10FilmsTheme {

        CompositionLocalProvider(
            values = arrayOf(
                LocalAppState provides appState,
                LocalSpacing provides Spacing(),
                LocalSystemUiController provides systemUiController
            )
        ) {

            Scaffold(
                bottomBar = {
                    BottomNavigation(
                        visible = appState.isBottomNavBarVisible,
                        currentRoute = appState.currentRoute,
                        shouldShowSplash = appState.shouldShowSplash,
                        onNavItemClick = { route -> appState.bottomNavigate(route) }
                    )
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    GunmetalDarkest,
                                    GunmetalDarker,
                                    Gunmetal,
                                    GunmetalLighter
                                )
                            )
                        )
                )
                RootNavGraph(
                    navController = navController,
                    shouldShowSplash = appState.shouldShowSplash
                )
            }
        }
    }
}

val LocalAppState = compositionLocalOf<AppState> {
    error("No App State")
}

val LocalSystemUiController = compositionLocalOf<SystemUiController> {
    error("No System Ui Controller")
}