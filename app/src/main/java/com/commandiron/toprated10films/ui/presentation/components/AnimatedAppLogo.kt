package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.theme.NoRippleTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AnimatedAppLogo(
    modifier: Modifier = Modifier,
    durationMillis: Int = 12000,
    delayMillis: Int = 0,
    onFinishOffsetMillis: Int = -3000,
    onFinish: () -> Unit
) {
    val rotation = remember {
        Animatable(0f)
    }
    val appLogoBobbinAlpha = remember {
        Animatable(1f)
    }
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit){
        launch {
            delay(durationMillis + onFinishOffsetMillis.toLong())
            onFinish()
        }
        launch {
            rotation.animateTo(
                targetValue = 360f * durationMillis / 2000,
                animationSpec = tween(
                    durationMillis = durationMillis,
                    delayMillis = delayMillis,
                    easing = LinearEasing
                )
            )
        }
        launch {
            repeat((durationMillis / (1000 / 24))) {
                appLogoBobbinAlpha.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = 0,
                        delayMillis = 0,
                        easing = LinearEasing
                    )
                )
                appLogoBobbinAlpha.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        durationMillis = 1000 / 24,
                        delayMillis = 0,
                        easing = LinearEasing
                    )
                )
            }
        }
    }
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Box(
            modifier = modifier
                .size(
                    width = 156.dp,
                    height = 100.dp
                )
                .clickable {
                    scope.launch {
                        appLogoBobbinAlpha.snapTo(1f)
                    }
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.app_logo_top),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .rotate(rotation.value),
                painter = painterResource(id = R.drawable.app_logo_bobbin),
                contentDescription = null,
                tint = Color.White.copy(
                    alpha = appLogoBobbinAlpha.value
                )
            )
        }
    }
}