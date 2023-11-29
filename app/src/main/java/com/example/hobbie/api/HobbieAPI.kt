package com.example.hobbie.api

import com.example.hobbie.models.Event
import com.example.hobbie.models.http.LoginRequest
import com.example.hobbie.models.http.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface HobbieAPI {

    @GET("/v1/api/events/2")
    suspend fun getPlayerEvents(): Response<Event>

    @Headers("Content-Type: application/json")
    @POST("/v1/api/auth/username-password")
    fun doLogin(@Body loginRequest: LoginRequest): Call<LoginResponse>
}