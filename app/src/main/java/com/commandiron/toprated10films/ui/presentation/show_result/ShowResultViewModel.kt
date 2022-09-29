package com.commandiron.toprated10films.ui.presentation.show_result

import androidx.lifecycle.ViewModel
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.ui.model.Film.Companion.defaultTopTenFilms
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ShowResultViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _title = MutableStateFlow("Adventure")
    val title = _title.asStateFlow()

    private val _topTenFilms = MutableStateFlow(defaultTopTenFilms)
    val topTenFilms = _topTenFilms.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
}