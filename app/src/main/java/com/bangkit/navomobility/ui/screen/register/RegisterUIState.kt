package com.bangkit.navomobility.ui.screen.register

data class RegisterUIState(
    var name: String = "",
    var email: String = "",
    var password: String = "",

    var nameError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError: Boolean = false,
)
