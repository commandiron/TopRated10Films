package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    hint: String,
    onSearch: (KeyboardActionScope.() -> Unit)? = null,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = onSearch
        ),
        singleLine = true,
        maxLines = 1
    ) { innerTextField ->
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = Color.White
        ) {
            Box(
                modifier = Modifier.padding(
                    horizontal = MaterialTheme.spacing.spaceLarge,
                    vertical = MaterialTheme.spacing.spaceMedium
                ),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty())
                    Text(
                        text = hint,
                        style = textStyle,
                        color = Color.Black.copy(
                            0.25f
                        )
                    )
                innerTextField()
            }
        }
    }
}