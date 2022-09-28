package com.commandiron.toprated10films.ui.presentation.actor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import com.commandiron.toprated10films.ui.model.Actor.Companion.actorList
import com.commandiron.toprated10films.ui.presentation.actor.components.ActorCard
import com.commandiron.toprated10films.ui.presentation.components.SearchTextField
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ActorScreen(
    onClick: () -> Unit
) {
    val text = remember { mutableStateOf("") }
    val isLoading = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.fillMaxWidth()) {
            Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
            SearchTextField(
                value = text.value,
                onValueChange = { text.value = it},
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
        if(isLoading.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = MaterialTheme.spacing.bottomNavHeight),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }else {
            Column() {
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
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(
                        horizontal = MaterialTheme.spacing.spaceMedium
                    )
                ){
                    items(actorList) { actor ->
                        ActorCard(
                            modifier = Modifier
                                .padding(MaterialTheme.spacing.spaceExtraSmall)
                                .clip(MaterialTheme.shapes.medium)
                                .aspectRatio(0.75f)
                                .clickable { onClick() },
                            actor = actor
                        )
                    }
                }
            }
        }
    }
}










