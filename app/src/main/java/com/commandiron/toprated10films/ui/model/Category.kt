package com.commandiron.toprated10films.ui.model

sealed class Category(
    val id: Int,
    val title: String,
    val imageUrl: String,
) {
    object AllTime: Category(
        id = 0,
        title = "All Time",
        imageUrl= "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
    )
    object ByActor: Category(
        id = 1,
        title = "By Actor",
        imageUrl= "https://media.bantmag.com/wp-content/uploads/2015/08/heath-joker-800x533.jpeg"
    )
    object ByGenre: Category(
        id = 2,
        title = "By Genre",
        imageUrl= "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
    )
    object ByYear: Category(
        id = 3,
        title = "By Year",
        imageUrl= "https://m.media-amazon.com/images/M/MV5BYjJiZjMzYzktNjU0NS00OTkxLWEwYzItYzdhYWJjN2QzMTRlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"
    )

    companion object {
        fun fromId(id: Int?): Category {
            return when(id) {
                0 -> AllTime
                1 -> ByActor
                2 -> ByGenre
                3 -> ByYear
                else -> { throw IllegalArgumentException() }
            }
        }
    }
}
