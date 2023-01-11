<p align="center">
  <img src="https://user-images.githubusercontent.com/50905347/211789281-b4126158-c605-4c50-81ee-dd75e6f03ff4.png" width="125" height="125">
</p>

<h1 align="center">TopRated10Films</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" width="80" height="20"> 
  <img src="https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white" width="80" height="20">
  <a href="https://android-arsenal.com/api?level=23"><img alt="API" src="https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat"/></a>
  </a> 
</p>

<p align="center">
    <a href='https://play.google.com/store/apps/details?id=com.commandiron.toprated10films'>
      <img src="https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png" width="206.72" height="80">
    </a>
  </p>

<p align="center">  
TopRated10Films is a native android movie app for create Top 10 movies in desired category, written in Kotlin using Jetpack Compose with themoviedb api.
</p>
</br>

<p align="center">
<img src="https://user-images.githubusercontent.com/50905347/211844036-b0c668ec-1a69-44b2-aa13-40458cde63f9.png">
</p>

* Ux 🧪

[Overview](art/topRatedTenFilms-overview.gif)

* Application - Features ☕
   * One time animated splash screen
   * Search
   * Paging
   * Nested navigation
   * Watchlist db
   * Language - English
* Tech-stack ⚛️
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operation
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose) - toolkit for building native UI
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation      
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
    * [Retrofit](https://square.github.io/retrofit/) - HTTP client
    * [Coil](https://coil-kt.github.io/coil/compose/) - image loading library
    * [Paging](https://developer.android.com/jetpack/androidx/releases/paging) -  load and display pages from a remote server.
    * [Room](https://developer.android.com/jetpack/androidx/releases/room) - database object mapping
    * [Accompanist](https://github.com/google/accompanist)
        * navigationAnimation
        * pager
        * systemUi
    * [Hilt](https://dagger.dev/hilt/) - DI
    * [Material 3](https://m3.material.io) - design
* Architecture 🏗️
    * Model-View-ViewModel
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
 
 * Todo ✔️
   * Shimmer Effect ✔️
   * Movie Details ✔️
   * by Country ❌
   * Different Screen Sizes and Orientation ❌
   * Light Theme ❌
   * Turkish Language ❌
