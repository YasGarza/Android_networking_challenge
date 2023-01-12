package com.example.android.networkconnect.data.model

data class Character(
        val id: Int,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val gender: String,
        val origin: PropertyDetail,
        val location: PropertyDetail,
        val image: String,
        val episodes: List<String>,
        val url: String,
        val created: String
)
