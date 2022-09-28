package com.commandiron.toprated10films.ui.presentation.genre.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.model.Genre
import com.commandiron.toprated10films.ui.presentation.components.TopTenSticker
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenreCard(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    genre: Genre
) {
    Box(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(genre.imageUrl)
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
            containerColor = Color.Transparent
        )
    ) {
        Box(Modifier.fillMaxSize()) {
            TopTenSticker(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(
                        horizontal = MaterialTheme.spacing.spaceExtraSmall,
                        vertical = MaterialTheme.spacing.spaceExtraSmall
                    )
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.8f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.spacing.spaceMedium,
                            vertical = MaterialTheme.spacing.spaceExtraSmall
                        ),
                    text = genre.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = textStyle
                )
            }
        }
    }
}