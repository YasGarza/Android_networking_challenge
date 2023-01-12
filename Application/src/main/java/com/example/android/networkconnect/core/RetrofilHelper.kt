package com.example.android.networkconnect.core

import com.example.android.networkconnect.data.ResourceType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofilHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}