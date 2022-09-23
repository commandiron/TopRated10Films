package com.commandiron.toprated10films.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                .padding(8.dp)
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.LightGray.copy(0.1f)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { onNavItemClick(GraphItem.TopTenGraph.route) },
                enabled = currentRoute != NavigationItem.WatchListScreen.route,
                iconTint = Color.LightGray,
                title = "Top",
                isIconFrontOfText = false
            )
            NavigationItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { onNavItemClick(NavigationItem.WatchListScreen.route) },
                enabled = currentRoute == NavigationItem.WatchListScreen.route,
                iconTint = Color.White,
                title = "Watchlist"
            )
        }
    }
}

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    resourceId: Int = com.commandiron.toprated10films.R.drawable.top_rated_ten_films_icon,
    iconVector: ImageVector = Icons.Default.Tv,
    iconTint: Color,
    title: String,
    isIconFrontOfText: Boolean = true
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.65f)
                .fillMaxWidth(0.75f),
            shape = RoundedCornerShape(32.dp),
            color = if(enabled) {
                MaterialTheme.colorScheme.primary
            }else MaterialTheme.colorScheme.background,
            border = if(!enabled) {
                BorderStroke(
                    width = 1.dp,
                    color = Color.Gray
                )
            }else null
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(isIconFrontOfText){
                    Icon(
                        imageVector = iconVector,
                        contentDescription = null,
                        tint = iconTint
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                if(!isIconFrontOfText){
                    Icon(
                        modifier = Modifier.fillMaxHeight(0.75f),
                        painter = painterResource(id = resourceId),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}