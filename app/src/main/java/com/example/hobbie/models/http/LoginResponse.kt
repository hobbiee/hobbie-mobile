package com.example.hobbie.models.http

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
)