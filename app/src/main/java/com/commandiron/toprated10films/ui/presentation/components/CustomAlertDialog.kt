package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun CustomAlertDialog(
    title: String,
    firstButtonText: String,
    secondButtonText: String,
    onDismiss:() -> Unit,
    onConfirm:() -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = firstButtonText,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = secondButtonText,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        titleContentColor = MaterialTheme.colorScheme.primary
    )
}