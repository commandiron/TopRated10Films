package com.commandiron.toprated10films.ui.model

import kotlin.random.Random

data class Popular(
    val title: String,
    val imageUrl: String? = null,
    val color: Long? = null,
    val category: Category
) {
    companion object {
        val popularList = listOf(
            Popular(
                title = "Horror",
                imageUrl = "https://sm.ign.com/t/ign_nl/gallery/t/the-25-bes/the-25-best-horror-movies_2smr.1080.jpg",
                category = Category.ByGenre
            ),
            Popular(
                title = "Brad Pitt",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMjA1MjE2MTQ2MV5BMl5BanBnXkFtZTcwMjE5MDY0Nw@@._V1_.jpg",
                category = Category.ByActor
            ),
            Popular(
                title = "1989",
                color = Random.nextLong(0xFFFFFFFF),
                category = Category.ByYear
            ),
            Popular(
                title = "Matt Damon",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMTM0NzYzNDgxMl5BMl5BanBnXkFtZTcwMDg2MTMyMw@@._V1_UY264_CR9,0,178,264_AL_.jpg",
                category = Category.ByActor
            ),
            Popular(
                title = "1989",
                color = Random.nextLong(0xFFFFFFFF),
                category = Category.ByYear
            ),
            Popular(
                title = "Brad Pitt",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMjA1MjE2MTQ2MV5BMl5BanBnXkFtZTcwMjE5MDY0Nw@@._V1_.jpg",
                category = Category.ByActor
            )
        )
    }
}
