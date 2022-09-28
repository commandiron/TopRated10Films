package com.commandiron.toprated10films.ui.presentation.actor.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.ui.model.Actor
import com.commandiron.toprated10films.ui.presentation.components.TopTenSticker
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun ActorCard(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    actor: Actor
) {
    Box(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(actor.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
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
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(
                    color = Color.Black.copy(alpha = 0.6f),
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.spaceMedium,
                        vertical = MaterialTheme.spacing.spaceExtraSmall
                    ),
                text = actor.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = textStyle
            )
        }
    }
}