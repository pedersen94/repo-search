package com.challenge.domain

/**
 * TODO(candidate): Is a use case warranted here, or is it ceremony?
 *  If you keep it, it depends on the abstraction above — never on a concrete
 *  data source. If you drop it, be ready to say why.
 */
class SearchRepositoriesUseCase(
    private val repository: RepositoryRepository,
) {
    suspend operator fun invoke(query: String): List<Repository> =
        repository.search(query)
}
