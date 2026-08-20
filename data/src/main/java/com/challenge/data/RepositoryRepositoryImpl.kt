package com.challenge.data

import com.challenge.domain.Repository
import com.challenge.domain.RepositoryRepository

/**
 * TODO(candidate): Implement the domain abstraction here.
 *  - map RepositoryDto -> domain Repository (consider a dedicated mapper)
 *  - decide how errors from the data source are handled/translated
 *  This class implements a DOMAIN interface but lives in :data — that's the
 *  dependency inversion in action.
 */
class RepositoryRepositoryImpl(
    private val remote: RepositoryRemoteDataSource,
) : RepositoryRepository {

    override suspend fun search(query: String): List<Repository> {
        TODO("Map the DTOs from `remote.search(query)` into domain models")
    }
}
