package com.commandiron.toprated10films.ui.presentation.show_result

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.ui.model.Category
import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _topTenFilms = MutableStateFlow<List<Film>>(emptyList())
    val topTenFilms = _topTenFilms.asStateFlow()

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
                                _topTenFilms.value = response.data
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
                                _topTenFilms.value = response.data
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
                                _topTenFilms.value = response.data
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
                                _topTenFilms.value = response.data
                            }
                        }
                    }
                }
            }
        }
    }
}