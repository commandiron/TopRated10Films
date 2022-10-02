package com.commandiron.toprated10films.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.navigation.nav_graph.GraphItem
import com.commandiron.toprated10films.ui.theme.*

@Composable
fun BottomNavigation(
    currentRoute: String?,
    shouldShowSplash: Boolean,
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
        visible = navigationItems.find { it.routeWithArgs() == currentRoute }?.isBottomBarVisible ?: false,
        enter = if(shouldShowSplash) {
            fadeIn(
                tween(
                    durationMillis = 1000,
                    delayMillis = 3000
                )
            )
        } else fadeIn(),
        exit = fadeOut()
    ) {
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.spaceSmall)
                .fillMaxWidth()
                .height(MaterialTheme.spacing.bottomNavHeight)
                .clip(MaterialTheme.shapes.large)
                .background(Gunmetal.copy(0.85f)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                NavigationItem(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { onNavItemClick(GraphItem.TopTenGraph.route) },
                    enabled = currentRoute != NavigationItem.WatchListScreen.route
                ){
                    Icon(
                        modifier = Modifier.fillMaxHeight(0.45f),
                        painter = painterResource(
                            id = if(currentRoute != NavigationItem.WatchListScreen.route) {
                                R.drawable.app_logo_bobbin
                            }else R.drawable.app_logo_bobbin,
                        ),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceSmall))
                    Row() {
                        Text(
                            text = "Top",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "10",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = if(currentRoute != NavigationItem.WatchListScreen.route) {
                                Color.White
                            } else MaterialTheme.colorScheme.primary
                        )
                    }

                }
                NavigationItem(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { onNavItemClick(NavigationItem.WatchListScreen.route) },
                    enabled = currentRoute == NavigationItem.WatchListScreen.route
                ){
                    Icon(
                        modifier = Modifier.fillMaxHeight(0.45f),
                        imageVector = Icons.Default.Tv,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceSmall))
                    Text(
                        text = "Watchlist",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.65f)
                .fillMaxWidth(0.75f),
            shape = MaterialTheme.shapes.extraLarge,
            color = if(enabled) {
                MaterialTheme.colorScheme.primary
            }else GunmetalDarker,
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
                content()
            }
        }
    }
}