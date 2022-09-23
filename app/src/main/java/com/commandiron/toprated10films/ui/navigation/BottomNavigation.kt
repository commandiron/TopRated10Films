package com.commandiron.toprated10films.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.commandiron.toprated10films.ui.navigation.nav_graph.GraphItem

@Composable
fun BottomNavigation(
    currentRoute: String?,
    onNavItemClick:(String) -> Unit
) {
    val navigationItems = listOf(
        NavigationItem.SplashScreen,
        NavigationItem.SelectionScreen,
        NavigationItem.ActorScreen,
        NavigationItem.GenreScreen,
        NavigationItem.YearScreen,
        NavigationItem.ShowResultScreen,
        NavigationItem.WatchListScreen
    )
    AnimatedVisibility(
        visible = navigationItems.find { it.route == currentRoute }?.isBottomBarVisible ?: false,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        BottomAppBar() {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { onNavItemClick(GraphItem.TopTenGraph.route) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "TOPTEN",
                    color = if(currentRoute != NavigationItem.WatchListScreen.route) {
                        Color.Red
                    } else Color.Black
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { onNavItemClick(NavigationItem.WatchListScreen.route) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "WATCHLIST",
                    color = if(currentRoute == NavigationItem.WatchListScreen.route) {
                        Color.Red
                    } else Color.Black
                )
            }
        }
    }
}