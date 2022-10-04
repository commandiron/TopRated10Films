package com.commandiron.toprated10films.ui.presentation.show_result

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.domain.model.WatchListFilm
import com.commandiron.toprated10films.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowResultViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val categoryId = savedStateHandle.getStateFlow("categoryId", 0)
    private val itemId = savedStateHandle.getStateFlow("itemId", 0)
    val title = savedStateHandle.getStateFlow("title", "")
    val imageUrl = savedStateHandle.getStateFlow("imageUrl", "")

    private val _topTen = MutableStateFlow<List<Film>>(emptyList())
    val topTen = _topTen.asStateFlow()

    private val _watchListFilms = MutableStateFlow<List<WatchListFilm>>(emptyList())

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        when(Category.fromId(categoryId.value)) {
            Category.AllTime -> {
                viewModelScope.launch {
                    useCases.getTopTenFilmsByAllTime().collect { response ->
                        when(response) {
                            is Response.Error -> {
                                _isLoading.value = false
                            }
                            Response.Loading -> {
                                _isLoading.value = true
                            }
                            is Response.Success -> {
                                _isLoading.value = false
                                _topTen.update {
                                    it + response.data
                                }
                                updateWatchListFilms()
                            }
                        }
                    }
                }
            }
            Category.ByActor -> {
                viewModelScope.launch {
                    useCases.getTopTenFilmsByActor(itemId.value).collect { response ->
                        when(response) {
                            is Response.Error -> {
                                _isLoading.value = false
                            }
                            Response.Loading -> {
                                _isLoading.value = true
                            }
                            is Response.Success -> {
                                _isLoading.value = false
                                _topTen.update {
                                    it + response.data
                                }
                                updateWatchListFilms()
                            }
                        }
                    }
                }
            }
            Category.ByGenre -> {
                viewModelScope.launch {
                    useCases.getTopTenFilmsByGenre(itemId.value).collect { response ->
                        when(response) {
                            is Response.Error -> {
                                _isLoading.value = false
                            }
                            Response.Loading -> {
                                _isLoading.value = true
                            }
                            is Response.Success -> {
                                _isLoading.value = false
                                _topTen.update {
                                    it + response.data
                                }
                                updateWatchListFilms()
                            }
                        }
                    }
                }
            }
            Category.ByYear -> {
                viewModelScope.launch {
                    useCases.getTopTenFilmsByYear(title.value.toInt()).collect { response ->
                        when(response) {
                            is Response.Error -> {
                                _isLoading.value = false
                            }
                            Response.Loading -> {
                                _isLoading.value = true
                            }
                            is Response.Success -> {
                                _isLoading.value = false
                                _topTen.update {
                                    it + response.data
                                }
                                updateWatchListFilms()
                            }
                        }
                    }
                }
            }
        }
    }

    fun addToWatchList(id: Int) {
        viewModelScope.launch {
            useCases.addToWatchList(WatchListFilm(id))
        }
        updateWatchListFilms()
    }

    fun removeFromWatchList(id: Int) {
        viewModelScope.launch {
            useCases.removeFromWatchList(WatchListFilm(id))
        }
        updateWatchListFilms()
    }

    private fun updateWatchListFilms() {
        viewModelScope.launch {
            useCases.getAllWatchListFilms().collect { watchListFilms ->
                _watchListFilms.update {
                    watchListFilms
                }
                updateTopTenFilms(watchListFilms)
            }
        }
    }

    private fun updateTopTenFilms(
        watchListFilms: List<WatchListFilm>
    ) {
        val inWatchListIndexes: MutableList<Int> = mutableListOf()

        _topTen.update { topTen ->

            topTen.toMutableList().also { mutableTopTen ->

                watchListFilms.forEach { watchListFilm ->

                    val watchListFilmInTopTen = mutableTopTen
                        .find { watchListFilm.id == it.id }

                    watchListFilmInTopTen?.let {
                        val index = mutableTopTen.indexOf(it)

                        inWatchListIndexes.add(index)

                        mutableTopTen[index] = mutableTopTen[index].copy(
                            isInWatchList = true
                        )
                    }
                }

                mutableTopTen.forEachIndexed { index, film ->
                    if(!inWatchListIndexes.contains(index)) {
                        mutableTopTen[index] = mutableTopTen[index].copy(
                            isInWatchList = false
                        )
                    }
                }
            }
        }
    }
}