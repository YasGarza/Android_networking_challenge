package com.example.android.networkconnect.ui.episodes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.networkconnect.data.model.Episode
import com.example.android.networkconnect.domain.GetEpisodesUseCase
import kotlinx.coroutines.launch

class EpisodesViewModel : ViewModel() {
    var getEpisodesUseCase = GetEpisodesUseCase()
    val episodes = MutableLiveData<List<Episode>>()

    fun onCreateView() {
        viewModelScope.launch {
            val result = getEpisodesUseCase.invoke()

            if (!result.isNullOrEmpty()) {
                episodes.postValue(result)
            }
        }
    }
}