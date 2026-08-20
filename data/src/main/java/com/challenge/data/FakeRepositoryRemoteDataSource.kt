package com.challenge.data

import kotlinx.coroutines.delay

/**
 * Provided fake so you can run without a network key.
 * - simulates latency with delay()
 * - "error" as a query throws, so you can exercise the error state
 * - "empty" (or anything with no matches) returns an empty list
 * You should not need to modify this file.
 */
class FakeRepositoryRemoteDataSource : RepositoryRemoteDataSource {

    override suspend fun search(query: String): List<RepositoryDto> {
        delay(700) // simulated network latency

        if (query.equals("error", ignoreCase = true)) {
            throw RuntimeException("Simulated network failure")
        }

        return canned.filter {
            it.full_name.contains(query, ignoreCase = true) ||
                (it.description?.contains(query, ignoreCase = true) == true)
        }
    }

    private val canned = listOf(
        RepositoryDto(1, "square/retrofit", "A type-safe HTTP client for Android and Java", 42000, OwnerDto("square", "https://avatars/1")),
        RepositoryDto(2, "JetBrains/kotlin", "The Kotlin Programming Language", 47000, OwnerDto("JetBrains", "https://avatars/2")),
        RepositoryDto(3, "android/compose-samples", "Official Jetpack Compose samples", 20000, OwnerDto("android", "https://avatars/3")),
        RepositoryDto(4, "Kotlin/kotlinx.coroutines", "Library support for Kotlin coroutines", 13000, OwnerDto("Kotlin", "https://avatars/4")),
        RepositoryDto(5, "google/dagger", "A fast dependency injector for Android and Java", 17000, OwnerDto("google", "https://avatars/5")),
        RepositoryDto(6, "coil-kt/coil", "Image loading for Android backed by Kotlin Coroutines", 10000, OwnerDto("coil-kt", "https://avatars/6")),
    )
}
