package com.commandiron.toprated10films.ui.presentation.selection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.LocalSystemUiController
import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.ui.presentation.components.bottomNavPadding
import com.commandiron.toprated10films.ui.presentation.selection.components.CategoryCard
import com.commandiron.toprated10films.ui.presentation.selection.components.PopularCard
import com.commandiron.toprated10films.ui.presentation.selection.components.SelectionBodyText
import com.commandiron.toprated10films.ui.theme.GunmetalDarkest
import com.commandiron.toprated10films.ui.theme.GunmetalLighter
import com.commandiron.toprated10films.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SelectionScreen(
    viewModel: SelectionViewModel = hiltViewModel(),
    onAllTimeClick: () -> Unit,
    onActorClick: () -> Unit,
    onGenreClick: () -> Unit,
    onYearClick: () -> Unit,
    onPopularItemClick: (
        categoryId: Int,
        itemId: Int,
        title: String,
        imageUrl: String?
    ) -> Unit
) {
    val systemUiController = LocalSystemUiController.current
    DisposableEffect(systemUiController) {
        systemUiController.setStatusBarColor(
            color = GunmetalDarkest
        )
        systemUiController.setNavigationBarColor(
            color = GunmetalLighter
        )
        onDispose {}
    }
    val populars = viewModel.populars.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .bottomNavPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
        Row(Modifier.fillMaxWidth()) {
            Spacer(Modifier.width(MaterialTheme.spacing.spaceLarge))
            Icon(
                modifier = Modifier.height(56.dp),
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        Spacer(Modifier.height(MaterialTheme.spacing.spaceLarge))
        HorizontalPager(
            count = 4,
            contentPadding = PaddingValues(horizontal = 80.dp),
        ) { page ->
            CategoryCard(
                modifier = Modifier
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
                    .aspectRatio(0.75f)
                    .clickable {
                        when (page) {
                            0 -> onAllTimeClick()
                            1 -> onActorClick()
                            2 -> onGenreClick()
                            3 -> onYearClick()
                        }
                    },
                category = when(page) {
                    0 -> Category.AllTime
                    1 -> Category.ByActor
                    2 -> Category.ByGenre
                    3 -> Category.ByYear
                    else -> Category.AllTime
                }
            )
        }
        Spacer(Modifier.height(MaterialTheme.spacing.spaceMedium))
        SelectionBodyText(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.spaceLarge
            ),
            textStyle = MaterialTheme.typography.titleLarge
        )
        Column(Modifier.fillMaxWidth()) {
            Spacer(Modifier.height(MaterialTheme.spacing.spaceMedium))
            Row {
                Spacer(Modifier.width(MaterialTheme.spacing.spaceMedium))
                Text(
                    text = "Popular lists",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            LazyRow {
                items(populars) { popular ->
                    PopularCard(
                        modifier = Modifier
                            .padding(
                                horizontal = MaterialTheme.spacing.spaceExtraSmall,
                                vertical = MaterialTheme.spacing.spaceMedium
                            )
                            .clip(MaterialTheme.shapes.medium)
                            .heightIn(max = 86.dp)
                            .aspectRatio(1f)
                            .clickable {
                                onPopularItemClick(
                                    popular.category.id,
                                    popular.id,
                                    popular.title,
                                    popular.imageUrl
                                )
                            },
                        popular = popular
                    )
                }
            }
        }
    }
}