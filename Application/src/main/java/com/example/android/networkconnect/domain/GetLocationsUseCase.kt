package com.example.android.networkconnect.domain

import com.example.android.networkconnect.data.ModelRepository
import com.example.android.networkconnect.data.model.Location

class GetLocationsUseCase {
    private val repository = ModelRepository()
    suspend fun invoke(): List<Location>? = repository.getLocations()
}