package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun TopTenSticker(
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(
                    color = Color.Black.copy(alpha = 0.5f)
                )
                .padding(
                    horizontal = MaterialTheme.spacing.spaceExtraSmall,
                    vertical = MaterialTheme.spacing.spaceExtraSmall
                )
        ) {
            Text(
                text = "Top",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
            Text(
                text = "10",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}