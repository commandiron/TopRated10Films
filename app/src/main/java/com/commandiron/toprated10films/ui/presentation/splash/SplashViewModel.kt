package com.commandiron.toprated10films.ui.presentation.splash

import androidx.lifecycle.ViewModel
import com.commandiron.toprated10films.domain.preferences.MyPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel@Inject constructor(
    private val preferences: MyPreferences
): ViewModel() {

    private val _splashDelay = MutableStateFlow(10000)
    val splashDelay = _splashDelay.asStateFlow()

    fun setShouldShowSplashScreenFalse(){
        preferences.saveShouldShowSplash(false)
    }
}