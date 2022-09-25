package com.commandiron.toprated10films.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
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
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.navigation.nav_graph.GraphItem
import com.commandiron.toprated10films.ui.theme.spacing

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
                .padding(MaterialTheme.spacing.spaceSmall)
                .fillMaxWidth()
                .height(MaterialTheme.spacing.bottomNavHeight)
                .clip(MaterialTheme.shapes.medium)
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
                resourceId = if(currentRoute != NavigationItem.WatchListScreen.route) {
                    R.drawable.app_logo_film
                }else R.drawable.app_logo_film,
                iconTint = Color.LightGray,
                title = "Topten"
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
                iconVector = Icons.Default.Tv,
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
    resourceId: Int? = null,
    iconVector: ImageVector? = null,
    iconTint: Color,
    title: String,
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
            shape = MaterialTheme.shapes.extraLarge,
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
                resourceId?.let {
                    Icon(
                        modifier = Modifier.fillMaxHeight(0.45f),
                        painter = painterResource(id = it),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                }
                iconVector?.let {
                    Icon(
                        modifier = Modifier.fillMaxHeight(0.45f),
                        imageVector = it,
                        contentDescription = null,
                        tint = iconTint
                    )
                }
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceSmall))
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}