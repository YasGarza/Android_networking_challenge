package com.example.android.networkconnect.ui.locations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.networkconnect.data.model.Location
import com.example.android.networkconnect.domain.GetLocationsUseCase
import kotlinx.coroutines.launch

class LocationsViewModel : ViewModel() {
    var getLocationsUseCase = GetLocationsUseCase()
    val locations = MutableLiveData<List<Location>>()

    fun onCreateView() {
        viewModelScope.launch {
            val result = getLocationsUseCase.invoke()

            if (!result.isNullOrEmpty()) {
                locations.postValue(result)
            }
        }
    }
}