package com.commandiron.toprated10films.ui.model

import kotlin.random.Random

data class Genre(
    val name: String,
    val color: Long = Random.nextLong(0xFFFFFFFF),
    val imageUrl: String? = "https://images.indianexpress.com/2020/05/shutter-island-759.jpg"
) {
    companion object {
        val defaultGenreList = listOf(
            Genre(
                name = "Action",
                imageUrl = "https://media.timeout.com/images/102512459/750/422/image.jpg"
            ),
            Genre(
                name = "Adventure",
                imageUrl = "https://netstorage-tuko.akamaized.net/images/62986d234ef17429.jpg?imwidth=900"
            ),
            Genre(
                name = "Animation",
                imageUrl = "https://i.ytimg.com/vi/FhKpGf0vdG8/maxresdefault.jpg"
            ),
            Genre(
                name = "Biography",
                imageUrl = "https://www.samuelthomasdavies.com/wp-content/uploads/2015/08/The-Shawshank-Redemption.jpg"
            ),
            Genre(
                name = "Comedy",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWAy32gkTPg78o8L9t_f98SJ6dstM65jOc8g&usqp=CAU"
            ),
            Genre(
                name = "Crime"
            ),
            Genre(
                name = "Drama"
            ),
            Genre(
                name = "Family"
            ),
            Genre(
                name = "Fantasy"
            ),
            Genre(
                name = "Film-Noir"
            ),
            Genre(
                name = "History"
            ),
            Genre(
                name = "Horror"
            ),
            Genre(
                name = "Music"
            ),
            Genre(
                name = "Musical"
            ),
            Genre(
                name = "Mystery"
            ),
            Genre(
                name = "Romance"
            ),
            Genre(
                name = "Sci-Fi"
            ),
            Genre(
                name = "Sport"
            ),
            Genre(
                name = "Thriller",
                imageUrl = "https://images.indianexpress.com/2020/05/shutter-island-759.jpg"
            ),
            Genre(
                name = "War"
            ),
            Genre(
                name = "Western"
            )
        )
    }
}