package com.commandiron.toprated10films.ui.presentation.selection

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.commandiron.toprated10films.R
import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.ui.model.TopTenItem
import com.commandiron.toprated10films.ui.presentation.selection.components.CategoryCard
import com.commandiron.toprated10films.ui.presentation.selection.components.PopularCard
import com.commandiron.toprated10films.ui.theme.spacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SelectionScreen(
    onActorClick: () -> Unit,
    onGenreClick: () -> Unit,
    onYearClick: () -> Unit,
    onPopularItemClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = MaterialTheme.spacing.bottomNavHeight
                        + MaterialTheme.spacing.spaceSmall
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
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
                CategoryCard(
                    category = when(page) {
                        0 -> Category.ByActor
                        1 -> Category.ByGenre
                        2 -> Category.ByYear
                        else -> Category.ByActor
                    },
                    pageOffset = calculateCurrentOffsetForPage(page).absoluteValue,
                    onClick = {
                        when(page) {
                            0 -> onActorClick()
                            1 -> onGenreClick()
                            2 -> onYearClick()
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceMedium))
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.spaceLarge
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Choose category.",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceMedium))
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.spacing.spaceExtraLarge
                        ),
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
                    items(TopTenItem.popularTopTenItems.size) { index ->
                        PopularCard(
                            topTenItem = TopTenItem.popularTopTenItems[index],
                            onClick = onPopularItemClick
                        )
                    }
                }
            }
        }
    }
}