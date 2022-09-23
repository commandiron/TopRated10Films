package com.commandiron.toprated10films

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.commandiron.toprated10films.ui.theme.TopRated10FilmsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopRated10FilmsTheme {
            }
        }
    }
}