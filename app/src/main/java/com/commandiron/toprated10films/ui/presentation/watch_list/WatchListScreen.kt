package com.commandiron.toprated10films.ui.presentation.watch_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.presentation.components.AppProgressIndicator
import com.commandiron.toprated10films.ui.presentation.components.CustomAlertDialog
import com.commandiron.toprated10films.ui.presentation.components.FilmCard
import com.commandiron.toprated10films.ui.presentation.components.bottomNavPadding
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun WatchListScreen(
    viewModel: WatchListViewModel = hiltViewModel()
) {
    val films = viewModel.films.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val showAlertDialog = remember { mutableStateOf(false) }
    val removedId = remember { mutableStateOf<Int?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
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
                    text = "Watchlist" + if(films.isNotEmpty()) "(${films.size})" else "",
                    style = MaterialTheme.typography.titleLarge
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
        }else {
            if(films.isNotEmpty()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2)
                ) {
                    items(films) { film ->
                        FilmCard(
                            modifier = Modifier
                                .padding(
                                    MaterialTheme.spacing.spaceSmall
                                )
                                .aspectRatio(0.67f)
                                .clip(MaterialTheme.shapes.medium),
                            film = film,
                            page = 0,
                            iconPaddings = PaddingValues(MaterialTheme.spacing.spaceSmall),
                            iconSizes = 36.dp,
                            queueIconEnabled = false,
                            onWatchListClick = {
                                showAlertDialog.value = true
                                removedId.value = it
                            }
                        )
                    }
                    item {
                        Spacer(Modifier.height(MaterialTheme.spacing.spaceXXLarge))
                    }
                    item {
                        Spacer(Modifier.height(MaterialTheme.spacing.spaceXXLarge))
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .bottomNavPadding(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No Movie Added")
                }
            }
        }
    }
    if(showAlertDialog.value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CustomAlertDialog(
                title = "Are you sure you want to remove it?",
                firstButtonText = "Yes",
                secondButtonText = "No",
                onDismiss = { showAlertDialog.value = false },
                onConfirm = {
                    showAlertDialog.value = false
                    removedId.value?.let {
                        viewModel.removeFromWatchList(it)
                        removedId.value = null
                    }
                }
            )
        }
    }
}