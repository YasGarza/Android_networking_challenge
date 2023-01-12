package com.example.android.networkconnect.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.networkconnect.data.model.Character
import com.example.android.networkconnect.domain.GetCharactersUseCase
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {
    var getCharactersUseCase = GetCharactersUseCase()
    val characters = MutableLiveData<List<Character>>()

    fun onCreateView() {
        viewModelScope.launch {
            val result = getCharactersUseCase.invoke()

            if (!result.isNullOrEmpty()) {
                characters.postValue(result)
            }
        }
    }
}