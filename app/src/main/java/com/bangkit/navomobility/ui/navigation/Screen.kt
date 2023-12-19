package com.bangkit.navomobility.ui.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen() {
    object SignUpScreen : Screen()
    object LoginScreen : Screen()
    object OnBoardingScreen : Screen()
    object ProfileScreen : Screen()
    object HomeScreen : Screen()
    object QuestionnaireScreen : Screen()
}

object NavoMobilityAppRouter {
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.OnBoardingScreen)

    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}
