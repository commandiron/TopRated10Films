package com.commandiron.toprated10films

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.commandiron.toprated10films.navigation.BottomNavigation
import com.commandiron.toprated10films.navigation.nav_graph.RootNavGraph
import com.commandiron.toprated10films.navigation.bottomNavigate
import com.commandiron.toprated10films.navigation.currentRoute
import com.commandiron.toprated10films.ui.theme.TopRated10FilmsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopRated10FilmsTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            currentRoute = navController.currentRoute(),
                            onNavItemClick = { route -> navController.bottomNavigate(route) }
                        )
                    },
                    containerColor = MaterialTheme.colorScheme.background
                ) {
                    RootNavGraph(navController = navController)
                }
            }
        }
    }
}