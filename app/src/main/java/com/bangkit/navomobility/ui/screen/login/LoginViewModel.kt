package com.bangkit.navomobility.ui.screen.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bangkit.navomobility.ui.navigation.NavoMobilityAppRouter
import com.bangkit.navomobility.ui.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel() : ViewModel(){

    private var TAG = LoginViewModel::class.simpleName
    var loginUIState = mutableStateOf(LoginUIState())
    var allValidationPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateDataWithRules()
    }

    private fun login() {

        loginInProgress.value = true

        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside login success")
                Log.d(TAG, "${it.isSuccessful}")

                if (it.isSuccessful) {
                    loginInProgress.value = false
                    NavoMobilityAppRouter.navigateTo(Screen.QuestionnaireScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside login failure")
                Log.d(TAG, "${it.localizedMessage}")
            }
    }

    private fun validateDataWithRules() {

        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationPassed.value = emailResult.status && passwordResult.status
    }
}