package com.commandiron.toprated10films.ui.presentation.watch_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.toprated10films.domain.model.Film
import com.commandiron.toprated10films.domain.model.WatchListId
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _films = MutableStateFlow<List<Film>>(emptyList())
    val films = _films.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        getAllWatchListFilms()
    }

    fun removeFromWatchList(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.removeFromWatchList(WatchListId(id)).collect { response ->
                when(response) {
                    is Response.Error -> {}
                    Response.Loading -> {}
                    is Response.Success -> {
                        getAllWatchListFilms(true)
                    }
                }
            }
        }
    }

    private fun getAllWatchListFilms(fromRemove: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllWatchListFilms().collect { response ->
                when(response) {
                    is Response.Error -> {
                        _isLoading.value = false
                    }
                    Response.Loading -> {
                        if(!fromRemove) {
                            _isLoading.value = true
                        }
                    }
                    is Response.Success -> {
                        _isLoading.value = false
                        _films.value = response.data
                    }
                }
            }
        }
    }
}