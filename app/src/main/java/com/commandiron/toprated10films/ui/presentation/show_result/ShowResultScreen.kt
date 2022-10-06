package com.commandiron.toprated10films.ui.presentation.show_result

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.presentation.components.AppProgressIndicator
import com.commandiron.toprated10films.ui.presentation.components.CustomAsyncImage
import com.commandiron.toprated10films.ui.presentation.components.FilmCard
import com.commandiron.toprated10films.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShowResultScreen(
    viewModel: ShowResultViewModel = hiltViewModel(),
) {
    val imageUrl: String = viewModel.imageUrl.collectAsState().value
    val title = viewModel.title.collectAsState().value
    val topTen = viewModel.topTen.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    CustomAsyncImage(
        modifier = Modifier
            .fillMaxSize(),
        imageUrl = imageUrl,
        alpha = 0.2f,
        noImageTitle = "",
        errorMessage = ""
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = MaterialTheme.spacing.bottomNavHeight
                        + MaterialTheme.spacing.spaceExtraSmall
            ),
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
        }else if(topTen.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No Data")
            }
        }else {
            val pagerState = rememberPagerState()
            val scope = rememberCoroutineScope()

            HorizontalPager(
                state = pagerState,
                count = topTen.size,
                contentPadding = PaddingValues(horizontal = 32.dp),
                key = {
                    topTen[it].id
                }
            ) { page ->
                Column() {
                    FilmCard(
                        modifier = Modifier
                            .graphicsLayer {
                                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                                lerp(
                                    start = 0.85f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                ).also { scale ->
                                    scaleX = scale
                                    scaleY = scale
                                }

                                alpha = lerp(
                                    start = 0.5f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                            }
                            .aspectRatio(0.67f),
                        film = topTen[page],
                        page = page,
                        bottomTitle = topTen[page].title + " (${topTen[page].releaseYear})",
                        onWatchListClick = {
                            if(topTen[page].isInWatchList) {
                                viewModel.removeFromWatchList(it)
                            }else {
                                viewModel.addToWatchList(it)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceMedium))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                enabled = page + 1 == topTen.size,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                scope.launch {
                                    pagerState.animateScrollToPage(
                                        page = 0
                                    )
                                }
                            }
                            .alpha(if(page + 1 == topTen.size) 1f else 0f),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                        Text(text = "Back to Start")
                    }
                }
            }

        }
    }
}