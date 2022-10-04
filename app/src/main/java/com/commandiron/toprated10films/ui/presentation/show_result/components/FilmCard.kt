package com.commandiron.toprated10films.ui.presentation.show_result.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToQueue
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.ui.presentation.components.CustomAsyncImage
import com.commandiron.toprated10films.ui.theme.NoRippleTheme
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmCard(
    modifier: Modifier = Modifier,
    film: Film,
    page: Int,
    onWatchListClick: (id: Int) -> Unit
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Box() {
                CustomAsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    imageUrl = film.imageUrl,
                    noImageTitle = "Poster not available"
                )
                Box(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.spaceMedium)
                        .align(Alignment.TopStart)
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Black.copy(alpha = 0.75f),
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = (page + 1).toString(),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.spaceMedium)
                        .align(Alignment.TopEnd)
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Black.copy(alpha = 0.75f),
                        )
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            onWatchListClick(film.id)
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.padding(
                            MaterialTheme.spacing.spaceSmall
                        ),
                        imageVector = if(film.isInWatchList) {
                            Icons.Default.Tv
                        } else Icons.Default.AddToQueue,
                        contentDescription = null,
                        tint = if(film.isInWatchList) {
                            MaterialTheme.colorScheme.primary
                        } else Color.White
                    )
                }
            }
        }
    }
}