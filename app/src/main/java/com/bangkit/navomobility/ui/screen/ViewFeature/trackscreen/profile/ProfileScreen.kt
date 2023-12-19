package com.bangkit.navomobility.ui.screen.ViewFeature.trackscreen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R
import com.bangkit.navomobility.ui.components.ButtonComponent
import com.bangkit.navomobility.ui.screen.register.RegisterViewModel

@Composable
fun ProfileScreen(registerViewModel: RegisterViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            ButtonComponent(
                value = stringResource(R.string.logout),
                onButtonClicked = { registerViewModel.logout() },
                isEnabled = true
            )
        }

    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen(
        registerViewModel = RegisterViewModel()
    )
}