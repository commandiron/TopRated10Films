package com.commandiron.toprated10films.ui.presentation.year.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.model.Year
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
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(year.imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.app_logo_bobbin),
            contentDescription = null,
            contentScale = ContentScale.Crop
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