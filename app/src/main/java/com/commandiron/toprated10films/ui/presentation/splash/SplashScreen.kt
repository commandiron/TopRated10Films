package com.commandiron.toprated10films.ui.presentation.splash


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.ui.presentation.components.AnimatedAppLogo
import com.commandiron.toprated10films.ui.presentation.components.FromCompanyComponent
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun SplashScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedAppLogo()
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onClick) {
            Text(text = "To Home Screen")
        }
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