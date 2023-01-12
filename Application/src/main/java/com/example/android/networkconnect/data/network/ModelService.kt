package com.example.android.networkconnect.data.network

import com.example.android.networkconnect.core.RetrofilHelper
import com.example.android.networkconnect.data.model.Character
import com.example.android.networkconnect.data.model.Episode
import com.example.android.networkconnect.data.model.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ModelService {
    private val retrofit = RetrofilHelper.getRetrofit()

    suspend fun getCharacters(): List<Character>? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ModelApiClient::class.java).getCharacters()
            response.body()?.results
        }
    }

    suspend fun getLocations(): List<Location>? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ModelApiClient::class.java).getLocations()
            response.body()?.results
        }
    }

    suspend fun getEpisodes(): List<Episode>? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ModelApiClient::class.java).getEpisodes()
            response.body()?.results
        }
    }
}