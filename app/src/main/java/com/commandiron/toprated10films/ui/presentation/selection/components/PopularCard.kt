package com.commandiron.toprated10films.ui.presentation.selection.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.ui.model.TopTenItem
import com.commandiron.toprated10films.ui.theme.NoRippleTheme
import com.commandiron.toprated10films.ui.theme.spacing

@Composable
fun PopularCard(
    topTenItem: TopTenItem,
    onClick: () -> Unit
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        if(topTenItem.category == Category.ByYear){
            YearCard(
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.spaceExtraSmall,
                        vertical = MaterialTheme.spacing.spaceMedium
                    )
                    .clip(MaterialTheme.shapes.medium)
                    .aspectRatio(1f)
                    .clickable { onClick() },
                title = topTenItem.title
            )
        }else {
            AsyncImage(
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.spaceExtraSmall,
                        vertical = MaterialTheme.spacing.spaceMedium
                    )
                    .clip(MaterialTheme.shapes.medium)
                    .aspectRatio(1f)
                    .clickable { onClick() },
                model = ImageRequest.Builder(LocalContext.current)
                    .data(topTenItem.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.app_logo_bobbin),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}