package com.commandiron.toprated10films.ui.presentation.show_result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.expandable_horizontal_pager.ExpandableHorizontalPager
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.presentation.components.AppProgressIndicator
import com.commandiron.toprated10films.ui.presentation.components.CustomAsyncImage
import com.commandiron.toprated10films.ui.presentation.components.FilmCard
import com.commandiron.toprated10films.ui.presentation.components.bottomNavPadding
import com.commandiron.toprated10films.ui.theme.Gunmetal
import com.commandiron.toprated10films.ui.theme.LocalSystemUiController
import com.commandiron.toprated10films.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShowResultScreen(
    viewModel: ShowResultViewModel = hiltViewModel(),
    onImageTransform:(expanded: Boolean) -> Unit
) {
    val imageUrl: String = viewModel.imageUrl.collectAsState().value
    val title = viewModel.title.collectAsState().value
    val topTen = viewModel.topTen.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value

    val systemUiController = LocalSystemUiController.current
    DisposableEffect(systemUiController) {
        systemUiController.setStatusBarColor(
            color = Color.Transparent
        )
        systemUiController.setNavigationBarColor(
            color = Color.Transparent
        )
        onDispose {}
    }

    CustomAsyncImage(
        modifier = Modifier
            .fillMaxSize(),
        imageUrl = imageUrl,
        alpha = 0.2f,
        placeHolderEnabled = false,
        noImageTitle = "",
        errorMessage = ""
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .bottomNavPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(MaterialTheme.spacing.spaceLarge))
            Icon(
                modifier = Modifier.height(56.dp),
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Row(
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(Modifier.width(MaterialTheme.spacing.spaceSmall))
                Text(
                    text = "Top",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "10 ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
        if(isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = MaterialTheme.spacing.bottomNavHeight),
                contentAlignment = Alignment.Center
            ) {
                AppProgressIndicator()
            }
        }
        if(topTen.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No Data")
            }
        }
    }

    val pagerState = rememberPagerState()

    BoxWithConstraints(Modifier.fillMaxSize()) {
        ExpandableHorizontalPager(
            state = pagerState,
            initialHorizontalPadding = 64.dp,
            count = topTen.size,
            key = {
                topTen[it].id
            },
            initialWidth = 360.dp,
            targetWidth = maxWidth,
            mainContent = { page, _ ->
                FilmCard(
                    film = topTen[page],
                    page = page,
                    iconPaddings = PaddingValues(
                        horizontal = MaterialTheme.spacing.spaceMedium,
                        vertical = MaterialTheme.spacing.spaceLarge
                    ),
                    onWatchListClick = {
                        if(topTen[page].isInWatchList) {
                            viewModel.removeFromWatchList(it)
                        }else {
                            viewModel.addToWatchList(it)
                        }
                    }
                )
            },
            overMainContentCollapsed = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(0.75f)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Details",
                            color = Color.White,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Icon(
                            modifier = Modifier.size(16.dp),
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            },
            overMainContentExpanded = { page ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(0.75f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = MaterialTheme.spacing.spaceSmall),
                            text = topTen[page].title + " (${topTen[page].releaseYear})",
                            color = Color.White,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            },
            hiddenContentContainerColor = Gunmetal,
            hiddenContent = { page ->
                LazyColumn{
                    item {
                        Text(
                            modifier = Modifier.padding(
                                start = MaterialTheme.spacing.spaceMedium,
                                end = MaterialTheme.spacing.spaceMedium,
                                top = MaterialTheme.spacing.spaceMedium,
                                bottom = MaterialTheme.spacing.spaceLarge
                            ),
                            text = topTen[page].overview
                        )
                    }
                    item {
                        Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
                    }
                }
            },
            onTransform = { onImageTransform(it) }
        )
    }
}