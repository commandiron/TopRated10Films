package com.commandiron.toprated10films.ui.presentation.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SelectionScreen(
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(text = "Selection Screen")
        Button(onClick = { onClick1() }) {
            Text(text = "To Actor")
        }
        Button(onClick = { onClick2() }) {
            Text(text = "To Genre")
        }
        Button(onClick = { onClick3() }) {
            Text(text = "To Year")
        }
    }
}