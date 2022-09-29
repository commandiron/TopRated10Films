package com.commandiron.toprated10films.ui.presentation.selection.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun SelectionBodyText(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row() {
            Text(
                text = "Choose ",
                style = textStyle,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Top",
                style = textStyle.copy(
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = "10 ",
                style = textStyle.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
            Text(
                text = "category.",
                style = textStyle,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceMedium))
        Text(
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.spaceExtraLarge
                ),
            text = "Choose the category you want to create the top 10 movies.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.LightGray,
            textAlign = TextAlign.Center
        )
    }
}