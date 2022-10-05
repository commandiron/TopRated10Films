package com.commandiron.toprated10films.ui.presentation.year.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.commandiron.toprated10films.ui.model.Year
import com.commandiron.toprated10films.ui.presentation.components.CustomAsyncImage
import com.commandiron.toprated10films.ui.presentation.components.TopTenSticker
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YearCard(
    modifier: Modifier = Modifier,
    year: Year
) {
    Box(
        modifier = modifier,
    ) {
        CustomAsyncImage(
            imageUrl = year.imageUrl
        )
    }
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color(year.color).copy(
                alpha = if(year.imageUrl != null ) 0.6f else 1f
            )
        )
    ) {
        Box {
            TopTenSticker(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(
                        horizontal = MaterialTheme.spacing.spaceExtraSmall,
                        vertical = MaterialTheme.spacing.spaceExtraSmall
                    )
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = year.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}