package com.commandiron.toprated10films.ui.presentation.selection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SelectionScreen(
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = MaterialTheme.spacing.bottomNavHeight
                        + MaterialTheme.spacing.spaceMedium
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Icon(
                modifier = Modifier.padding(MaterialTheme.spacing.spaceLarge),
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        HorizontalPager(
            count = 3,
            contentPadding = PaddingValues(horizontal = 80.dp),
        ) { page ->
            Card(
                Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                AsyncImage(
                    modifier = Modifier.clickable {
                        when(page){
                            0 -> onClick1()
                            1 -> onClick2()
                            2 -> onClick3()
                        }
                    },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://tr.web.img4.acsta.net/pictures/19/09/11/16/43/1511539.jpg")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.app_logo_bobbin),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceLarge))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Choose category.",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceMedium))
            Text(
                text = "Choose the category you want to create the top 10 movies.",
                style = MaterialTheme.typography.bodySmall,
                color = Color.LightGray,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceLarge))
            Row {
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceMedium))
                Text(
                    text = "Popular lists",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            LazyRow {
                items(6) { index ->
                    when (index) {
                        0,1,2,3,4 -> {
                            AsyncImage(
                                modifier = Modifier
                                    .padding(
                                        horizontal = MaterialTheme.spacing.spaceExtraSmall,
                                        vertical = MaterialTheme.spacing.spaceMedium
                                    )
                                    .clip(MaterialTheme.shapes.medium)
                                    .aspectRatio(1f),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Brad_Pitt_2019_by_Glenn_Francis.jpg/220px-Brad_Pitt_2019_by_Glenn_Francis.jpg")
                                    .crossfade(true)
                                    .build(),
                                placeholder = painterResource(R.drawable.app_logo_bobbin),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                        5 -> {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .padding(
                                            horizontal = MaterialTheme.spacing.spaceExtraSmall,
                                            vertical = MaterialTheme.spacing.spaceMedium
                                        )
                                        .clip(MaterialTheme.shapes.medium)
                                        .aspectRatio(1f)
                                        .blur(8.dp),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Brad_Pitt_2019_by_Glenn_Francis.jpg/220px-Brad_Pitt_2019_by_Glenn_Francis.jpg")
                                        .crossfade(true)
                                        .build(),
                                    placeholder = painterResource(R.drawable.app_logo_bobbin),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = "+15",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}