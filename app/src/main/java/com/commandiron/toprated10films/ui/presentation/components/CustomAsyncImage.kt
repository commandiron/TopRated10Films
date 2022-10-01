package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    imageUrl: String?
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.app_logo_bobbin_placeholder),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}