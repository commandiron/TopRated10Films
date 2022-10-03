package com.commandiron.toprated10films.domain.use_cases

import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.domain.model.Popular
import kotlin.random.Random

class GetPopulars {
    operator fun invoke(): List<Popular> {
        return listOf(
            Popular(
                id = 28,
                title = "Action",
                imageUrl = "https://media.timeout.com/images/102512459/750/422/image.jpg",
                category = Category.ByGenre
            ),
            Popular(
                id = 287,
                title = "Brad Pitt",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMjA1MjE2MTQ2MV5BMl5BanBnXkFtZTcwMjE5MDY0Nw@@._V1_.jpg",
                category = Category.ByActor
            ),
            Popular(
                id = 0,
                title = "2000",
                color = Random.nextLong(0xFFFFFFFF),
                category = Category.ByYear
            ),
            Popular(
                id = 27,
                title = "Horror",
                imageUrl = "https://sm.ign.com/t/ign_nl/gallery/t/the-25-bes/the-25-best-horror-movies_2smr.1080.jpg",
                category = Category.ByGenre
            ),
            Popular(
                id = 1892,
                title = "Matt Damon",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMTM0NzYzNDgxMl5BMl5BanBnXkFtZTcwMDg2MTMyMw@@._V1_UY264_CR9,0,178,264_AL_.jpg",
                category = Category.ByActor
            ),
            Popular(
                id = 0,
                title = "1976",
                color = Random.nextLong(0xFFFFFFFF),
                category = Category.ByYear
            ),
            Popular(
                id = 112,
                title = "Cate Blanchett",
                imageUrl = "https://i.pinimg.com/564x/1a/d3/38/1ad33885f7b3616b69cc8356cfa3910a--cate-blanchett-beautiful-ladies.jpg",
                category = Category.ByActor
            )
        )
    }
}