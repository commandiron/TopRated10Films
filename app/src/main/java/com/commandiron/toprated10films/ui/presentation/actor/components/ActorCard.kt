package com.commandiron.toprated10films.ui.presentation.actor.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.model.Actor
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActorCard(
    modifier: Modifier = Modifier,
    actor: Actor,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(MaterialTheme.spacing.spaceExtraSmall)
            .clip(MaterialTheme.shapes.medium)
            .aspectRatio(0.75f)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box() {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(actor.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.app_logo_bobbin),
                contentDescription = null,
                contentScale = ContentScale.Crop
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
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
            }
        }
    }
}