package com.commandiron.toprated10films.ui.presentation.splash


import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.toprated10films.ui.presentation.components.AnimatedAppLogo
import com.commandiron.toprated10films.ui.presentation.components.FromCompanyComponent
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onFinish: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedAppLogo(
            durationMillis = viewModel.splashDelay.collectAsState().value,
            onFinish = {
                viewModel.setShouldShowSplashFalse()
                onFinish()
            }
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = MaterialTheme.spacing.spaceExtraLarge),
        contentAlignment = Alignment.BottomCenter
    ) {
        FromCompanyComponent()
    }
}