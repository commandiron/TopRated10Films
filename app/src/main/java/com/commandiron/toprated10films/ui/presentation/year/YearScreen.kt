package com.commandiron.toprated10films.ui.presentation.year

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun YearScreen(
    onClick: () -> Unit
) {
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(text = "Year Screen")
        Button(onClick = { onClick() }) {
            Text(text = "To Show Result Screen")
        }
    }
}