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

    val imageUrl = savedStateHandle.getStateFlow("imageUrl", "")

    val title = savedStateHandle.getStateFlow("title", "")

    private val actorId = savedStateHandle.getStateFlow("actorId", 0)

    private val genreId = savedStateHandle.getStateFlow("genreId", 0)

    private val year = savedStateHandle.getStateFlow("year", 0)

    private val _topTenFilms = MutableStateFlow<List<Film>>(emptyList())
    val topTenFilms = _topTenFilms.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        val categoryId: Int? = savedStateHandle["categoryId"]
        when(Category.fromId(categoryId)) {
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
                    useCases.getTopTenFilmsByActor(actorId.value).collect { response ->
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
                    useCases.getTopTenFilmsByGenre(genreId.value).collect { response ->
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
                    useCases.getTopTenFilmsByYear(year.value).collect { response ->
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