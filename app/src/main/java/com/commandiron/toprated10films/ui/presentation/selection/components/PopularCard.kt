package com.commandiron.toprated10films.ui.presentation.selection.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.commandiron.toprated10films.domain.model.Actor
import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.domain.model.Popular
import com.commandiron.toprated10films.ui.model.*
import com.commandiron.toprated10films.ui.presentation.actor.components.ActorCard
import com.commandiron.toprated10films.ui.presentation.genre.components.GenreCard
import com.commandiron.toprated10films.ui.presentation.year.components.YearCard
import com.commandiron.toprated10films.ui.theme.NoRippleTheme

@Composable
fun PopularCard(
    modifier: Modifier = Modifier,
    popular: Popular
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Box(modifier = modifier) {
            when(popular.category) {
                Category.ByActor -> {
                    ActorCard(
                        actor = Actor(
                            id = popular.id,
                            name = popular.title,
                            imageUrl = popular.imageUrl ?: ""
                        ),
                        textStyle = MaterialTheme.typography.labelLarge
                    )
                }
                Category.ByGenre -> {
                    GenreCard(
                        genre = Genre(
                            id = popular.id,
                            name = popular.title,
                            imageUrl = popular.imageUrl
                        ),
                        textStyle = MaterialTheme.typography.labelLarge
                    )
                }
                Category.ByYear -> {
                    YearCard(
                        year = Year(
                            name = popular.title,
                            color = 0xFF000000
                        )
                    )
                }
                else -> {}
            }
        }
    }
}