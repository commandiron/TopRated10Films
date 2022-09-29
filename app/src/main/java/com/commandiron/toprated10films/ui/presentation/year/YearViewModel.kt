package com.commandiron.toprated10films.ui.presentation.year

import androidx.lifecycle.ViewModel
import com.commandiron.toprated10films.domain.use_cases.UseCases
import com.commandiron.toprated10films.ui.model.Genre.Companion.defaultGenreList
import com.commandiron.toprated10films.ui.model.Year.Companion.defaultYearList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class YearViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _years = MutableStateFlow(defaultYearList)
    val years = _years.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun search(text: String) {
        _searchText.value = text
    }
}