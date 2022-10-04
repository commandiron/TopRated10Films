package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.commandiron.toprated10films.R

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    alpha: Float = 1.0f,
    noImageTitle: String = "Image not available",
    onLoading: ((AsyncImagePainter.State.Loading) -> Unit)? = null,
    onSuccess: ((AsyncImagePainter.State.Success) -> Unit)? = null,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
) {
    if(imageUrl.isNullOrEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = noImageTitle,
                textAlign = TextAlign.Center
            )
        }
    }else {
        AsyncImage(
            modifier = modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.app_logo_bobbin_placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = alpha,
            onLoading = onLoading,
            onSuccess = onSuccess,
            onError = onError
        )
    }
}