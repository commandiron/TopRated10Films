package com.commandiron.toprated10films.ui.presentation.selection.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.ui.model.TopTenItem
import com.commandiron.toprated10films.ui.theme.NoRippleTheme
import com.commandiron.toprated10films.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularCard(
    modifier: Modifier = Modifier,
    topTenItem: TopTenItem
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        if(topTenItem.category == Category.ByYear){
            YearCard(
                modifier = modifier,
                title = topTenItem.title
            )
        }else {
            Card(
                modifier = modifier,
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .aspectRatio(1f),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(topTenItem.imageUrl)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.app_logo_bobbin),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(
                                horizontal = MaterialTheme.spacing.spaceExtraSmall,
                                vertical = MaterialTheme.spacing.spaceExtraSmall
                            )
                    ) {
                        Text(
                            text = "Top",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "10",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Card(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black.copy(
                                alpha = 0.6f
                            )
                        )
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(
                                    horizontal = MaterialTheme.spacing.spaceSmall
                                ),
                            text = topTenItem.title,
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}