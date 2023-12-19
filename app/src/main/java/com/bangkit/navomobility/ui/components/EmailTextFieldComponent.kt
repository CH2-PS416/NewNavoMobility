package com.bangkit.navomobility.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextFieldComponent(
    onValueChanged: (String) -> Unit,
    onInvalidFormat: () -> Unit,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {
    var emailText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = emailText,
        onValueChange = {
            emailText = it
            if (it.endsWith("@gmail.com")) {
                onValueChanged(it)
            } else {
                onInvalidFormat()
            }
            onTextSelected(it)
        },
        label = { Text(text = "Email") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(Color.White),
        isError = !errorStatus
    )
}
