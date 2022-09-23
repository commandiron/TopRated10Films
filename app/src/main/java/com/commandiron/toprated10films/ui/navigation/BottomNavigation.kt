package com.commandiron.toprated10films.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.LightGray.copy(0.1f)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { onNavItemClick(GraphItem.TopTenGraph.route) },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = null,
                    tint = if(currentRoute != NavigationItem.WatchListScreen.route) {
                        MaterialTheme.colorScheme.primary
                    }else Color.White
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Topten",
                    style = MaterialTheme.typography.bodySmall,
                    color = if(currentRoute != NavigationItem.WatchListScreen.route) {
                        MaterialTheme.colorScheme.primary
                    }else Color.White
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { onNavItemClick(NavigationItem.WatchListScreen.route) },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Tv,
                    contentDescription = null,
                    tint = if(currentRoute == NavigationItem.WatchListScreen.route) {
                        MaterialTheme.colorScheme.primary
                    }else Color.White
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Watchlist",
                    style = MaterialTheme.typography.bodySmall,
                    color = if(currentRoute == NavigationItem.WatchListScreen.route) {
                        MaterialTheme.colorScheme.primary
                    }else Color.White
                )
            }
        }
    }
}