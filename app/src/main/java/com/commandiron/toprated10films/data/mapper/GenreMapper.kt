package com.commandiron.toprated10films.data.mapper

import com.commandiron.toprated10films.data.model.MovieDbGenre
import com.commandiron.toprated10films.domain.model.Genre

fun MovieDbGenre.toGenre(): Genre {
    return Genre(
        name = name,
        imageUrl = when(name) {
            "Action" -> "https://media.timeout.com/images/102512459/750/422/image.jpg"
            "Adventure" -> "https://netstorage-tuko.akamaized.net/images/62986d234ef17429.jpg?imwidth=900"
            "Animation" -> "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/bam-incredibles-resize-1537212803.jpg?crop=0.689xw:1.00xh;0.107xw,0&resize=480:*"
            "Comedy" -> "https://m.media-amazon.com/images/M/MV5BZDQwMjNiMTQtY2UwYy00NjhiLTk0ZWEtZWM5ZWMzNGFjNTVkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg"
            "Crime" -> "https://img.mensxp.com/media/content/2017/Dec/the-top-10-crime-thriller-movies-of-20171400-1513772701.jpg"
            "Documentary" -> "https://assets.vogue.com/photos/5a01d1bf8b86ae229b942517/4:3/w_1688,h_1266,c_limit/00-promo-image-best-documentaries.jpg"
            "Drama" -> "https://i.ytimg.com/vi/SXvRYwDgZjs/movieposter_en.jpg"
            "Family" -> "https://m.media-amazon.com/images/M/MV5BMTI1NTQ3MjEyM15BMl5BanBnXkFtZTcwMzUxMzIzMQ@@._V1_.jpg"
            "Fantasy" -> "https://www.looper.com/img/gallery/what-the-final-days-on-the-set-of-lotr-the-return-of-the-king-were-like/production-actually-ended-twice-1617827765.jpg"
            "History" -> "https://m.media-amazon.com/images/M/MV5BOTIxMTUzMmUtODU2MS00MDhjLTlmMGQtMzNhZTFhOTI5ZjE5XkEyXkFqcGdeQXRoaXJkLXBhcnR5LXZpZGVvLXVwZGF0ZXI@._V1_QL75_UX500_CR0,47,500,281_.jpg"
            "Horror" -> "https://i1.wp.com/filmloverss.com/wp-content/uploads/2020/06/the-shining-3-filmloverss.jpg?resize=759%2C500&ssl=1"
            "Music" -> "https://cdn.theatlantic.com/thumbor/4KBFG18Aaiq59OitWkm_H5aHY7I=/0x1:1296x730/960x540/media/img/mt/2014/10/Whiplash/original.jpg"
            "Mystery" -> "https://static1.srcdn.com/wordpress/wp-content/uploads/2020/05/The-Prestige-Movie-Christian-Bale-Hugh-Jackman.jpg"
            "Romance" -> "https://seyler.ekstat.com/img/max/800/R/R9lLWX2w8xxRYkUx-637189167195454874.jpg"
            "Science Fiction" -> "https://parade.com/.image/t_share/MTkwNTgxNDAzODk3MTExNjc3/the-matrix-movies-ranked.jpg"
            "TV Movie" -> "https://www.atlasofplaces.com/atlas-of-places-images/_scaled/ATLAS-OF-PLACES-LUMET-SIDNEY-12-ANGRY-MEN-IMG-6.jpg"
            "Thriller" -> "https://m.media-amazon.com/images/M/MV5BN2ZiYzIyMWQtNDUyNy00YmExLWIwNmMtN2FhNzFiODgyYmU4XkEyXkFqcGdeQXRodW1ibmFpbC1pbml0aWFsaXplcg@@._V1_QL75_UY281_CR10,0,500,281_.jpg"
            "War" -> "https://dv2oc5tyj18yr.cloudfront.net/reel13/files/2021/03/ViewerGuide_ThePiano.jpg"
            "Western" -> "https://www.hollywoodreporter.com/wp-content/uploads/2013/02/django_1.jpg?w=1024"
            else -> "https://media.timeout.com/images/102512459/750/422/image.jpg"
        }
    )
}