package com.example.hobbie.api.session

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val sessionManager: SessionManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (sessionManager.noAuthToken()) {
            return chain.proceed(chain.request())
        }
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", "Bearer ${sessionManager.fetchAuthToken()}")
        return chain.proceed(requestBuilder.build())
    }
}