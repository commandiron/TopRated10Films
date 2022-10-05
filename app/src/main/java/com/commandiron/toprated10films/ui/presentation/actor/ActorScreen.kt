package com.commandiron.toprated10films.ui.presentation.actor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.commandiron.toprated10films.ui.presentation.actor.components.ActorCard
import com.commandiron.toprated10films.ui.presentation.actor.components.items
import com.commandiron.toprated10films.ui.presentation.components.AppProgressIndicator
import com.commandiron.toprated10films.ui.presentation.components.SearchTextField
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)
@Composable
fun ActorScreen(
    viewModel: ActorViewModel = hiltViewModel(),
    onClick: (actorId: Int, actorName: String, imageUrl: String?) -> Unit
) {
    val searchText = viewModel.searchText.collectAsState().value
    val actors = viewModel.actors.collectAsLazyPagingItems()
    val isLoading = viewModel.isLoading.collectAsState().value
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val isImeVisible = WindowInsets.isImeVisible
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                focusManager.clearFocus()
                keyboardController?.hide()
                viewModel.search(searchText)
            },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.fillMaxWidth()) {
            Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
            SearchTextField(
                value = searchText,
                onValueChange = { viewModel.search(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.spaceMedium),
                hint = "Search Actor",
                onSearch = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            )
            Spacer(Modifier.height(MaterialTheme.spacing.spaceSmall))
        }
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
            Column(Modifier.fillMaxWidth()) {
                if(searchText.isEmpty()) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(
                                horizontal = MaterialTheme.spacing.spaceLarge
                            ),
                        text = "Popular",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(MaterialTheme.spacing.spaceSmall))
                }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(
                        horizontal = MaterialTheme.spacing.spaceMedium
                    )
                ){
                    items(
                        items = actors,
                    ) { actor ->
                        actor?.let {
                            ActorCard(
                                modifier = Modifier
                                    .padding(MaterialTheme.spacing.spaceExtraSmall)
                                    .clip(MaterialTheme.shapes.medium)
                                    .aspectRatio(0.75f)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null
                                    ) {
                                        if (isImeVisible) {
                                            focusManager.clearFocus()
                                            keyboardController?.hide()
                                        } else {
                                            onClick(it.id, it.name, it.imageUrl)
                                        }
                                    },
                                actor = it
                            )
                        }
                    }
                }
            }
        }
    }
}










