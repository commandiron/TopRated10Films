package com.commandiron.toprated10films.ui.presentation.show_result

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.domain.model.WatchListId
import com.commandiron.toprated10films.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    private val _watchListIds = MutableStateFlow<List<WatchListId>>(emptyList())

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        when(Category.fromId(categoryId.value)) {
            Category.AllTime -> {
                viewModelScope.launch(Dispatchers.IO) {
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
                                updateWatchListIds()
                            }
                        }
                    }
                }
            }
            Category.ByActor -> {
                viewModelScope.launch(Dispatchers.IO) {
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
                                updateWatchListIds()
                            }
                        }
                    }
                }
            }
            Category.ByGenre -> {
                viewModelScope.launch(Dispatchers.IO) {
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
                                updateWatchListIds()
                            }
                        }
                    }
                }
            }
            Category.ByYear -> {
                viewModelScope.launch(Dispatchers.IO) {
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
                                updateWatchListIds()
                            }
                        }
                    }
                }
            }
        }
    }

    fun addToWatchList(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.addToWatchList(WatchListId(id)).collect { response ->
                when(response) {
                    is Response.Error -> {}
                    Response.Loading -> {}
                    is Response.Success -> {
                        updateWatchListIds()
                    }
                }
            }
        }
    }

    fun removeFromWatchList(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.removeFromWatchList(WatchListId(id)).collect { response ->
                when(response) {
                    is Response.Error -> {}
                    Response.Loading -> {}
                    is Response.Success -> {
                        updateWatchListIds()
                    }
                }
            }
        }
    }

    private fun updateWatchListIds() {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllWatchListIds().collect { watchListIds ->
                _watchListIds.update {
                    watchListIds
                }
                updateTopTenFilms(watchListIds)
            }
        }
    }

    private fun updateTopTenFilms(
        watchListIds: List<WatchListId>
    ) {
        _topTen.update { topTen ->

            topTen.toMutableList().also { mutableTopTen ->

                mutableTopTen.forEach { film ->

                    val index = mutableTopTen.indexOf(film)

                    if(watchListIds.contains(WatchListId(id = film.id))){
                        mutableTopTen[index] = mutableTopTen[index].copy(
                            isInWatchList = true
                        )
                    }else {
                        mutableTopTen[index] = mutableTopTen[index].copy(
                            isInWatchList = false
                        )
                    }
                }
            }
        }
    }
}