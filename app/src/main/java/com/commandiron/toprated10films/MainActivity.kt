package com.commandiron.toprated10films

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.commandiron.toprated10films.domain.preferences.AppPreferences
import com.commandiron.toprated10films.navigation.BottomNavigation
import com.commandiron.toprated10films.navigation.bottomNavigate
import com.commandiron.toprated10films.navigation.currentRoute
import com.commandiron.toprated10films.navigation.nav_graph.RootNavGraph
import com.commandiron.toprated10films.ui.theme.*
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: AppPreferences

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowSplash = preferences.loadShouldShowSplash()
        setContent {
            TopRated10FilmsTheme {
                val navController = rememberAnimatedNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            currentRoute = navController.currentRoute(),
                            shouldShowSplash = shouldShowSplash,
                            onNavItemClick = { route -> navController.bottomNavigate(route) }
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
                        shouldShowSplash = shouldShowSplash
                    )
                }
            }
        }
    }
}