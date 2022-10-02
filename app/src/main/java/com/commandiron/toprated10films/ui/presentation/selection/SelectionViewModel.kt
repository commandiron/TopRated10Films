package com.commandiron.toprated10films.ui.presentation.selection

import androidx.lifecycle.ViewModel
import com.commandiron.toprated10films.domain.model.Popular
import com.commandiron.toprated10films.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SelectionViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _populars = MutableStateFlow<List<Popular>>(emptyList())
    val populars = _populars.asStateFlow()

    init {
        getPopulars()
    }

    private fun getPopulars() {
        _populars.value = useCases.getPopulars()
    }
}