package com.bangkit.navomobility.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.navomobility.R
import com.bangkit.navomobility.ui.theme.NavoMobilityTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = androidx.compose.ui.Alignment.Center,
    ) {
        val logo: Painter = painterResource(id = R.drawable.logo)

        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp, 200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Fit
        )

        LaunchedEffect(key1 = true) {
            delay(3000)
            navigateToLogin()
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun SplashScreenPreview() {
    NavoMobilityTheme {
        SplashScreen {
        }
    }
}