package com.commandiron.toprated10films

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.commandiron.toprated10films.ui.navigation.RootNavGraph
import com.commandiron.toprated10films.ui.theme.TopRated10FilmsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopRated10FilmsTheme {
                val navController = rememberNavController()
                RootNavGraph(navController = navController)
            }
        }
    }
}