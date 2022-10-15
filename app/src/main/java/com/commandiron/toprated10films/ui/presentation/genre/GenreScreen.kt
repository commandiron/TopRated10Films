package com.commandiron.toprated10films.ui.presentation.genre

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.toprated10films.ui.presentation.components.AppProgressIndicator
import com.commandiron.toprated10films.ui.presentation.components.SearchTextField
import com.commandiron.toprated10films.ui.presentation.genre.components.GenreCard
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)
@Composable
fun GenreScreen(
    viewModel: GenreViewModel = hiltViewModel(),
    onClick: (genreId: Int, genreName: String, imageUrl: String?) -> Unit
) {
    val searchText = viewModel.searchText.collectAsState().value
    val genres = viewModel.filteredGenres.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val isImeVisible = WindowInsets.isImeVisible
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
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
                hint = "Search Genre",
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
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(
                    horizontal = MaterialTheme.spacing.spaceMedium
                )
            ){
                items(genres) { genre ->
                    GenreCard(
                        modifier = Modifier
                            .padding(MaterialTheme.spacing.spaceExtraSmall)
                            .clip(MaterialTheme.shapes.medium)
                            .aspectRatio(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                if(isImeVisible) {
                                    focusManager.clearFocus()
                                    keyboardController?.hide()
                                } else {
                                    onClick(genre.id, genre.name, genre.imageUrl)
                                }
                            },
                        genre = genre
                    )
                }
                item {
                    Spacer(Modifier.height(MaterialTheme.spacing.spaceXXXLarge))
                }
            }
        }
    }
}