package com.example.hobbie.api

import com.example.hobbie.models.Event
import retrofit2.Response
import retrofit2.http.GET

interface HobbieAPI {

    @GET("/v1/api/events/2")
    suspend fun getPlayerEvents(): Response<Event>

}