package com.example.android.networkconnect.data

import com.example.android.networkconnect.data.model.Character
import com.example.android.networkconnect.data.model.Episode
import com.example.android.networkconnect.data.model.Location
import com.example.android.networkconnect.data.network.ModelService

class ModelRepository {
    private val api = ModelService()

    suspend fun getCharacters(): List<Character>? {
        return api.getCharacters()
    }

    suspend fun getLocations(): List<Location>? {
        return api.getLocations()
    }

    suspend fun getEpisodes(): List<Episode>? {
        return api.getEpisodes()
    }
}