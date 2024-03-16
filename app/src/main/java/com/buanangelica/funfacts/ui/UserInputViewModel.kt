package com.buanangelica.funfacts.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.buanangelica.funfacts.data.UserDataUiEvents
import com.buanangelica.funfacts.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    companion object{
        const val TAG = "UserInoutViewModel"
    }
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value  = uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG, "${uiState.value}")
            }
        }

    }
}


