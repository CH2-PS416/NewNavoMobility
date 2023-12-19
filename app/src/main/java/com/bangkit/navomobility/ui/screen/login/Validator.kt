package com.bangkit.navomobility.ui.screen.login

object Validator {

    fun validateEmail(email: String) : ValidationResult {
        return ValidationResult(
            (email.isNotEmpty())
        )
    }

    fun validatePassword(password: String) : ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length >= 8)
        )
    }
}

data class ValidationResult(val status: Boolean = false)