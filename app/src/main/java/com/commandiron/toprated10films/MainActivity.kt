package com.commandiron.toprated10films

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.commandiron.toprated10films.domain.preferences.AppPreferences
import com.commandiron.toprated10films.ui.App
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: AppPreferences

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            val windowSizeClass = calculateWindowSizeClass(this)

            App(
                preferences = preferences,
                windowSizeClass = windowSizeClass,
            )
        }
    }
}