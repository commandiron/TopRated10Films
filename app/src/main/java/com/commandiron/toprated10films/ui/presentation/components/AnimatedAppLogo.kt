package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.R

@Composable
fun AnimatedAppLogo(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(
                width = 156.dp,
                height = 100.dp
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.app_logo_top),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Icon(
            modifier = Modifier.align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.app_logo_film),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}