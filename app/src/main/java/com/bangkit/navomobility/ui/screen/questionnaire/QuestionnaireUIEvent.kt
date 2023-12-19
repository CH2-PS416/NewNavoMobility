package com.bangkit.navomobility.ui.screen.questionnaire

sealed class QuestionnaireUIEvent {
    data class PlaceEntered(val place: String) : QuestionnaireUIEvent()

    object QuestionButtonClicked : QuestionnaireUIEvent()
}
