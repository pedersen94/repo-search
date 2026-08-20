package com.challenge.domain

/**
 * Clean domain model. Framework-free.
 * Note this is a DIFFERENT shape from the network DTO in the data layer —
 * mapping between them is your job.
 */
data class Repository(
    val id: Long,
    val name: String,
    val description: String?,
    val stars: Int,
)
