package com.commandiron.toprated10films.ui.presentation.actor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.domain.model.Actor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _actors = MutableStateFlow<PagingData<Actor>>(PagingData.empty())
    val actors = _actors

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        getActors()
    }

    fun search(text: String) {
        _searchText.value = text
        getActors()
    }

    private fun getActors() {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getActors(_searchText.value).cachedIn(viewModelScope).collect { response ->
                actors.value = response
            }
        }
    }
}