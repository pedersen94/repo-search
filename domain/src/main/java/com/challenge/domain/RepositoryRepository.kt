package com.challenge.domain

/**
 * The repository ABSTRACTION lives in the domain layer (dependency inversion).
 * The implementation lives in :data and depends on this — the arrow points inward.
 *
 * TODO(candidate): Decide how errors should surface. Raw exceptions? A domain
 *  Result type? Typed errors? Make a choice and justify it.
 */
interface RepositoryRepository {
    suspend fun search(query: String): List<Repository>
}
