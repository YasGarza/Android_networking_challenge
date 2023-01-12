package com.example.android.networkconnect.domain

import com.example.android.networkconnect.data.ModelRepository
import com.example.android.networkconnect.data.model.Character

class GetCharactersUseCase {
    private val repository = ModelRepository()
    suspend fun invoke(): List<Character>? = repository.getCharacters()
}