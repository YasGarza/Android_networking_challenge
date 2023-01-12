package com.example.android.networkconnect.data.model

import com.google.gson.annotations.SerializedName

data class Episode(
        val id: Int,
        val name: String,
        @SerializedName("air_time")
        val airTime: String,
        val episode: String,
        val characters: List<String>,
        val url: String,
        val created: String
)
