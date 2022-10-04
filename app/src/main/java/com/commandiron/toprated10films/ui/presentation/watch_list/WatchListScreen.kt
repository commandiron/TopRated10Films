package com.commandiron.toprated10films.ui.presentation.watch_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.presentation.show_result.components.FilmCard
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun WatchListScreen(
    viewModel: WatchListViewModel = hiltViewModel(),
) {
    val films = viewModel.films.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = MaterialTheme.spacing.bottomNavHeight + MaterialTheme.spacing.spaceExtraSmall
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
        Row(Modifier.fillMaxWidth()) {
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
                    text = "Watchlist",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
        if(isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(films) { film ->
                    FilmCard(
                        modifier = Modifier
                            .padding(
                                MaterialTheme.spacing.spaceSmall
                            )
                            .aspectRatio(0.67f),
                        film = film,
                        page = 0,
                        iconPaddings = MaterialTheme.spacing.spaceSmall,
                        iconSizes = 36.dp,
                        queueIconEnabled = false,
                        onWatchListClick = { viewModel.removeFromWatchList(it) }
                    )
                }
            }
        }
    }
}