package com.example.hobbie.api

import com.example.hobbie.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuotesAPI {

    @GET("/api/random")
    suspend fun getTodayQuote(): Response<List<Quote>>
}