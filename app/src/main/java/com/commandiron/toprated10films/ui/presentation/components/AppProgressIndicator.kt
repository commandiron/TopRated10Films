package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.R
import kotlinx.coroutines.launch

@Composable
fun AppProgressIndicator(
    modifier: Modifier = Modifier,
    durationMillis: Int = 2000,
    delayMillis: Int = 0
) {
    val rotation = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = Unit){
        launch {
            rotation.animateTo(
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = durationMillis,
                        delayMillis = delayMillis,
                        easing = LinearEasing
                    )
                )
            )
        }
    }
    Icon(
        modifier = modifier
            .size(40.dp)
            .rotate(rotation.value),
        painter = painterResource(id = R.drawable.app_logo_bobbin),
        contentDescription = null,
        tint = Color.White
    )
}