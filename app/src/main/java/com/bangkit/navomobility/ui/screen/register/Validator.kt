package com.bangkit.navomobility.ui.screen.register

object Validator {

    fun validateName(name: String) : ValidationResult {
        return ValidationResult(
            (name.isEmpty() && name.length >= 3)
        )
    }

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