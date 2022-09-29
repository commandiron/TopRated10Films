package com.commandiron.toprated10films.ui.presentation.show_result.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.model.Film
import com.commandiron.toprated10films.ui.theme.NoRippleTheme
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmCard(
    modifier: Modifier = Modifier,
    film: Film,
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Box() {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(film.imageUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.app_logo_bobbin),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.spaceMedium)
                        .align(Alignment.TopStart)
                        .clip(CircleShape)
                        .background(
                            color = Color.Black.copy(alpha = 0.75f),
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                horizontal = MaterialTheme.spacing.spaceMedium,
                                vertical = MaterialTheme.spacing.spaceSmall
                            ),
                        text = film.placement.toString(),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}