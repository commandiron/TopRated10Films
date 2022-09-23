package com.commandiron.toprated10films.ui.presentation.actor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ActorScreen(
    onClick: () -> Unit
) {
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(text = "Actor Screen")
        Button(onClick = { onClick() }) {
            Text(text = "To Show Result Screen")
        }
    }
}