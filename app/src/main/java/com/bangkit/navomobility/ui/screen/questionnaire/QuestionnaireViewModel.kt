package com.bangkit.navomobility.ui.screen.questionnaire

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class QuestionnaireViewModel : ViewModel() {

    private var TAG = QuestionnaireViewModel::class.simpleName
    var uiState = mutableStateOf(QuestionnaireScreenState())
    var allValidationPassed = mutableStateOf(false)

    fun onEvent(event: QuestionnaireUIEvent) {
        when (event) {
            is QuestionnaireUIEvent.PlaceEntered -> {
                uiState.value = uiState.value.copy(
                    placeSelected = event.place
                )
                Log.d(TAG, "onEvent:PlaceSelected->")
                Log.d(TAG, "${uiState.value}")
            }

            else -> {}
        }
    }
}