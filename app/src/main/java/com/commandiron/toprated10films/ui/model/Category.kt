package com.commandiron.toprated10films.ui.model

sealed class Category(
    val title: String,
    val imageUrl: String,
) {
    object ByActor: Category(
        title = "By Actor",
        imageUrl= "https://media.bantmag.com/wp-content/uploads/2015/08/heath-joker-800x533.jpeg"
    )
    object ByGenre: Category(
        title = "By Genre",
        imageUrl= "https://tr.web.img4.acsta.net/pictures/19/09/11/16/43/1511539.jpg"
    )
    object ByYear: Category(
        title = "By Year",
        imageUrl= "https://i.pinimg.com/736x/6d/b9/d0/6db9d061ba16452d1909eac46e65ca6b.jpg"
    )
}
