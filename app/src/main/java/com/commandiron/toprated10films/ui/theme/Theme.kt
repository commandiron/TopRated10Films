package com.commandiron.toprated10films.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    background = Gunmetal,
    onBackground = Color.White,
    primary = RedSalsa,
    onPrimary = Color.White
)

private val LightColorScheme = lightColorScheme(
    background = Gunmetal,
    onBackground = Color.White,
    primary = RedSalsa,
    onPrimary = Color.White
)

@Composable
fun TopRated10FilmsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val systemUiController = rememberSystemUiController()

    CompositionLocalProvider(
        values = arrayOf(
            LocalSpacing provides Spacing(),
            LocalSystemUiController provides systemUiController,
        )
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = Color.Transparent

    @Composable
    override fun rippleAlpha() = RippleAlpha(
        draggedAlpha = 0.0f,
        focusedAlpha = 0.0f,
        hoveredAlpha = 0.0f,
        pressedAlpha = 0.0f,
    )
}

val LocalSystemUiController = compositionLocalOf<SystemUiController> {
    error("No System Ui Controller")
}
