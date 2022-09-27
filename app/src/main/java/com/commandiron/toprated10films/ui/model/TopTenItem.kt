package com.commandiron.toprated10films.ui.model

data class TopTenItem(
    val title: String,
    val imageUrl: String,
    val category: Category,
    val films: List<Film>
) {
    companion object {
        val popularTopTenItems = listOf(
            TopTenItem(
                title = "Horror",
                imageUrl = "https://sm.ign.com/t/ign_nl/gallery/t/the-25-bes/the-25-best-horror-movies_2smr.1080.jpg",
                films = listOf(),
                category = Category.ByGenre
            ),
            TopTenItem(
                title = "Brad Pitt",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Brad_Pitt_2019_by_Glenn_Francis.jpg/220px-Brad_Pitt_2019_by_Glenn_Francis.jpg",
                films = listOf(),
                category = Category.ByActor
            ),
            TopTenItem(
                title = "1989",
                imageUrl = "https://bestsimilar.com/img/tag/thumb/ea/8390.jpg",
                films = listOf(),
                category = Category.ByYear
            ),
            TopTenItem(
                title = "Matt Damon",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMTM0NzYzNDgxMl5BMl5BanBnXkFtZTcwMDg2MTMyMw@@._V1_UY264_CR9,0,178,264_AL_.jpg",
                films = listOf(),
                category = Category.ByActor
            ),
            TopTenItem(
                title = "1999",
                imageUrl = "https://bestsimilar.com/img/tag/thumb/ea/8390.jpg",
                films = listOf(),
                category = Category.ByYear
            ),
            TopTenItem(
                title = "Brad Pitt",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Brad_Pitt_2019_by_Glenn_Francis.jpg/220px-Brad_Pitt_2019_by_Glenn_Francis.jpg",
                films = listOf(),
                category = Category.ByActor
            ),
        )
    }
}
