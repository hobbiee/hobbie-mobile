package com.example.hobbie.models.http

sealed class LoginResponse(
    val token: String,
    val refreshToken: String
)