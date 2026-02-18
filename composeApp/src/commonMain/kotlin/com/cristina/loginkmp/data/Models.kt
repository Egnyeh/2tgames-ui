package com.cristina.loginkmp.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)

@Serializable
data class LoginResponse(
    val access_token: String,
    val token_type: String
)


@Serializable
data class User(
    val id: String,
    val username: String,
    val email: String? = null
)
