package com.commandiron.toprated10films.ui.presentation.actor.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.commandiron.toprated10films.domain.model.Actor
import com.commandiron.toprated10films.ui.presentation.components.CustomAsyncImage
import com.commandiron.toprated10films.ui.presentation.components.TopTenSticker
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun ActorCard(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    actor: Actor
) {
    Box(modifier = modifier) {
        CustomAsyncImage(
            modifier = Modifier.fillMaxSize(),
            imageUrl = actor.imageUrl
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
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color.Black
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
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