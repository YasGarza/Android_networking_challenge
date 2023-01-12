package com.example.android.networkconnect.data.network

import com.example.android.networkconnect.data.model.*
import retrofit2.Response
import retrofit2.http.GET

interface ModelApiClient {
    @GET("character")
    suspend fun getCharacters(): Response<ResponseCharacters>

    @GET("episode")
    suspend fun getEpisodes(): Response<ResponseEpisodes>

    @GET("location")
    suspend fun getLocations(): Response<ResponseLocations>
}