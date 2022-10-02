package com.commandiron.toprated10films.ui.presentation.selection

import androidx.lifecycle.ViewModel
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.ui.model.Popular.Companion.defaultPopularList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SelectionViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _populars = MutableStateFlow(defaultPopularList)
    val populars = _populars.asStateFlow()

}