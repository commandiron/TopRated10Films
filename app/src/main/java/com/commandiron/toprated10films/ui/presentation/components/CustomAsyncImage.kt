package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    alpha: Float = 1.0f,
    placeHolderEnabled: Boolean = true,
    noImageTitle: String = "Image not available",
    errorMessage: String = "Image loading failed",
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
        SubcomposeAsyncImage(
            modifier = modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .allowHardware(false)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            onState = { state ->
                when(state) {
                    AsyncImagePainter.State.Empty -> {}
                    is AsyncImagePainter.State.Error -> {
                        if(onError != null) {
                            onError(state)
                        }
                    }
                    is AsyncImagePainter.State.Loading -> {
                        if (onLoading != null) {
                            onLoading(state)
                        }
                    }
                    is AsyncImagePainter.State.Success -> {
                        if(onSuccess != null) {
                            onSuccess(state)
                        }
                    }
                }
            },
            contentScale = ContentScale.Crop,
            alpha = alpha
        ) {
            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    if(placeHolderEnabled) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .placeholder(
                                    visible = true,
                                    color = Color.Gray.copy(0.5f),
                                    shape = RoundedCornerShape(4.dp),
                                    highlight = PlaceholderHighlight
                                        .shimmer(highlightColor = Color.White)
                                ),
                            contentAlignment = Alignment.Center
                        ) {}
                    }
                }
                is AsyncImagePainter.State.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = errorMessage,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                else -> {
                    SubcomposeAsyncImageContent()
                }
            }
        }
    }
}