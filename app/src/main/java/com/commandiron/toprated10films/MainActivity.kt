package com.commandiron.toprated10films

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.commandiron.toprated10films.ui.navigation.NavigationItem
import com.commandiron.toprated10films.ui.presentation.splash.SplashScreen
import com.commandiron.toprated10films.ui.presentation.top_ten.TopTenScreen
import com.commandiron.toprated10films.ui.presentation.watch_list.WatchListScreen
import com.commandiron.toprated10films.ui.theme.TopRated10FilmsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopRated10FilmsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationItem.SplashScreen.route
                ){
                    composable(NavigationItem.SplashScreen.route) {
                        SplashScreen()
                    }
                    composable(NavigationItem.TopTenScreen.route) {
                        TopTenScreen()
                    }
                    composable(NavigationItem.WatchListScreen.route) {
                        WatchListScreen()
                    }
                }
            }
        }
    }
}