package com.example.hobbie.di

import android.content.Context
import com.example.hobbie.api.HobbieAPI
import com.example.hobbie.api.session.Constants
import com.example.hobbie.api.session.SessionManager
import com.example.hobbie.api.session.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(httpClient: okhttp3.OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesHobbieAPI(retrofit: Retrofit): HobbieAPI {
        return retrofit.create(HobbieAPI::class.java)
    }

    @Singleton
    @Provides
    fun providesSessionManager(@ApplicationContext context: Context): SessionManager {
        return SessionManager(context)
    }

    @Singleton
    @Provides
    fun providesTokenInterceptor(sessionManager: SessionManager): TokenInterceptor {
        return TokenInterceptor(sessionManager)
    }

    @Singleton
    @Provides
    fun providesHttpClient(tokenInterceptor: TokenInterceptor): okhttp3.OkHttpClient {
        return okhttp3.OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .build()
    }

}