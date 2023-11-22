package com.example.hobbie.di

import com.example.hobbie.api.HobbieAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://hobbie-labs-301323ee4a69.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesHobbieAPI(retrofit: Retrofit): HobbieAPI {
        return retrofit.create(HobbieAPI::class.java)
    }

}