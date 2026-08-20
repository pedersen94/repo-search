package com.challenge.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle
import com.challenge.domain.SearchRepositoriesUseCase

/**
 * TODO(candidate):
 *  - Expose the query and the UI state to the screen.
 *  - Debounce input (~300ms) and cancel any in-flight search when the query
 *    changes (think about slow old responses racing newer ones).
 *  - Surface Loading/Success/Empty/Error, and survive configuration changes
 *    (and ideally process death).
 *
 * Dependencies are injected via the constructor — do NOT `new` the use case,
 * repository, or data source inside this class.
 */
class SearchViewModel(
    private val searchRepositories: SearchRepositoriesUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    // TODO: expose query + uiState

    fun onQueryChange(value: String) {
        TODO("Update the query")
    }
}
