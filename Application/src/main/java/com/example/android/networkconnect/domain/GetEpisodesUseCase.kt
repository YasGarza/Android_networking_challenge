package com.example.android.networkconnect.domain

import com.example.android.networkconnect.data.ModelRepository
import com.example.android.networkconnect.data.model.Episode

class GetEpisodesUseCase {
    private val repository = ModelRepository()
    suspend fun invoke(): List<Episode>? = repository.getEpisodes()
}