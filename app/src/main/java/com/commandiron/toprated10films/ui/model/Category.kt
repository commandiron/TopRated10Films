package com.commandiron.toprated10films.ui.model

sealed class Category(
    val title: String,
    val imageUrl: String,
) {
    object ByActor: Category(
        title = "By Actor",
        imageUrl= "https://tr.web.img4.acsta.net/pictures/19/09/11/16/43/1511539.jpg"
    )
    object ByGenre: Category(
        title = "By Genre",
        imageUrl= "https://tr.web.img4.acsta.net/pictures/19/09/11/16/43/1511539.jpg"
    )
    object ByYear: Category(
        title = "By Year",
        imageUrl= "https://tr.web.img4.acsta.net/pictures/19/09/11/16/43/1511539.jpg"
    )
}
