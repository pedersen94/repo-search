package com.challenge.app

import com.challenge.domain.Repository

/**
 * TODO(candidate): Model the UI state so that illegal states are unrepresentable.
 *  The screen needs to render: an idle/prompt state, loading, results, an
 *  empty-results state, and an error. Prefer a sealed hierarchy over a bag of
 *  booleans + nullable fields.
 *
 * Example shape (yours to design):
 *   sealed interface SearchUiState {
 *       data object Idle : SearchUiState
 *       data object Loading : SearchUiState
 *       data class Success(val repos: List<Repository>) : SearchUiState
 *       data object Empty : SearchUiState
 *       data class Error(val message: String) : SearchUiState
 *   }
 */
sealed interface SearchUiState {
    // your design here
}
