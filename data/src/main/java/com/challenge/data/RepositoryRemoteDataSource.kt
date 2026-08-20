package com.challenge.data

/**
 * Raw data source abstraction. Returns DTOs and throws on error.
 * A real implementation would use Retrofit; the fake below lets you run offline.
 */
interface RepositoryRemoteDataSource {
    suspend fun search(query: String): List<RepositoryDto>
}
