package com.orion.threads.models

data class Thread(
    val profileImage: Int,
    val name: String,
    val time: String,
    val message: String,
    val messagePhoto: Int? = null,
    val isVerified: Boolean = false
)

