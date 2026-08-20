package com.challenge.data

/**
 * "Network" DTO — deliberately a different shape / naming from the domain model.
 * Do NOT let this type leak into the domain or presentation layers.
 */
data class RepositoryDto(
    val id: Long,
    val full_name: String,
    val description: String?,
    val stargazers_count: Int,
    val owner: OwnerDto,
)

data class OwnerDto(
    val login: String,
    val avatar_url: String,
)
