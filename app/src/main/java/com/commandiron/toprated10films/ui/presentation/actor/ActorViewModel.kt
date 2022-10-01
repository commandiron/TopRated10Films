package com.commandiron.toprated10films.ui.presentation.actor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.ui.model.Actor.Companion.defaultActorList
import com.commandiron.toprated10films.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _actors = MutableStateFlow(defaultActorList)
    val actors = _actors.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            useCases.getActors(2).collect { response ->
                when(response) {
                    is Response.Error -> {

                    }
                    Response.Loading -> {

                    }
                    is Response.Success -> {
                        println(response.data)
                        _actors.value = response.data
                    }
                }
            }
        }
    }

    fun search(text: String) {
        _searchText.value = text
    }
}