package com.bangkit.navomobility

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bangkit.navomobility.ui.navigation.NavoMobilityAppRouter
import com.bangkit.navomobility.ui.navigation.Screen
import com.bangkit.navomobility.ui.screen.ViewFeature.trackscreen.homescreen.HomeScreen
import com.bangkit.navomobility.ui.screen.login.LoginScreen
import com.bangkit.navomobility.ui.screen.login.LoginViewModel
import com.bangkit.navomobility.ui.screen.onboarding.OnBoardingScreen
import com.bangkit.navomobility.ui.screen.questionnaire.QuestionnaireScreen
import com.bangkit.navomobility.ui.screen.questionnaire.QuestionnaireViewModel
import com.bangkit.navomobility.ui.screen.register.RegisterScreen
import com.bangkit.navomobility.ui.screen.register.RegisterViewModel

@Composable
fun NavoMobilityApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Crossfade(
            targetState = NavoMobilityAppRouter.currentScreen,
            label = ""
        ) { currentState ->
            when (currentState.value) {
                is Screen.OnBoardingScreen -> {
                    OnBoardingScreen(
                        navigateToLogin = { NavoMobilityAppRouter.navigateTo(Screen.LoginScreen) }
                    )
                }

                is Screen.SignUpScreen -> {
                    RegisterScreen(
                        onBackClick = { NavoMobilityAppRouter.navigateTo(Screen.LoginScreen) },
                        registerViewModel = RegisterViewModel()
                    )
                }

                is Screen.LoginScreen -> {
                    LoginScreen(
                        onBackClick = { NavoMobilityAppRouter.navigateTo(Screen.OnBoardingScreen) },
                        loginViewModel = LoginViewModel()
                    )
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }

                is Screen.QuestionnaireScreen -> {
                    QuestionnaireScreen(
                        questionnaireViewModel = QuestionnaireViewModel(),
                        goToHomeScreen = {
                            NavoMobilityAppRouter.navigateTo(Screen.HomeScreen)
                        }
                    )
                }

                else -> {}
            }
        }
    }
}