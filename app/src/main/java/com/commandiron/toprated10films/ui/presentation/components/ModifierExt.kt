package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.commandiron.toprated10films.ui.theme.spacing

fun Modifier.bottomNavPadding(): Modifier = composed {
    this.padding(
        bottom = MaterialTheme.spacing.bottomNavHeight
                + MaterialTheme.spacing.spaceMedium
    )
}
