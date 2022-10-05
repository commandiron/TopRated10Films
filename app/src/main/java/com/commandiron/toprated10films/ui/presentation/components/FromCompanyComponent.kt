package com.commandiron.toprated10films.ui.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun FromCompanyComponent(
    modifier: Modifier = Modifier,
    companyName: String = "CITECH",
    companyColor: Color = Color(0xFFED7600),
    fromText: String = "From",
    textColor: Color = Color.White.copy(0.5f)
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = fromText,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            color = textColor
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceExtraSmall))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.height(20.dp),
                painter = painterResource(id = R.drawable.ci_tech_logo),
                contentDescription = companyName,
                tint = companyColor
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceSmall))
            Text(
                text = companyName,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = companyColor
            )
        }
    }
}