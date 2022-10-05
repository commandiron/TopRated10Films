package com.commandiron.toprated10films.ui.presentation.genre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.toprated10films.domain.model.Genre
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _genres = MutableStateFlow<List<Genre>>(emptyList())

    private val _filteredGenres = MutableStateFlow<List<Genre>>(emptyList())
    val filteredGenres = _filteredGenres.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getGenres().collect { response ->
                when(response) {
                    is Response.Error -> {
                        _isLoading.value = false
                    }
                    Response.Loading -> {
                        _isLoading.value = true
                    }
                    is Response.Success -> {
                        _isLoading.value = false
                        _genres.value = response.data
                        _filteredGenres.value = response.data
                    }
                }
            }
        }

    }

    fun search(text: String) {
        _searchText.value = text
        _filteredGenres.value = useCases.filterGenres(
            text,
            _genres.value
        )
    }
}