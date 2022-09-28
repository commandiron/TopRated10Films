package com.commandiron.toprated10films.ui.presentation.year

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.commandiron.toprated10films.ui.model.Year
import com.commandiron.toprated10films.ui.presentation.components.SearchTextField
import com.commandiron.toprated10films.ui.presentation.year.components.YearCard
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun YearScreen(
    onClick: () -> Unit
) {
    val text = remember { mutableStateOf("") }
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
                hint = "Search Year",
                onSearch = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            )
            Spacer(Modifier.height(MaterialTheme.spacing.spaceSmall))
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spaceMedium
            )
        ){
            items(Year.yearList) { year ->
                YearCard(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.spaceExtraSmall)
                        .clip(MaterialTheme.shapes.medium)
                        .aspectRatio(1f)
                        .clickable { onClick() },
                    year = year
                )
            }
            item {
                Spacer(Modifier.height(MaterialTheme.spacing.spaceXXLarge))
            }
        }
    }
}
