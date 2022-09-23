package com.commandiron.toprated10films.ui.presentation.top_ten

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TopTenScreen() {
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text(text = "Top Ten Screen")
    }
}