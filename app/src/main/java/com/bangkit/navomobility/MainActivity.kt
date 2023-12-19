package com.bangkit.navomobility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.bangkit.navomobility.ui.screen.ViewFeature.trackscreen.MainScreen
import com.bangkit.navomobility.ui.theme.BottomNavBarDemoTheme
import com.bangkit.navomobility.ui.theme.NavoMobilityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            NavoMobilityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavoMobilityApp()
                }

                    MainScreen()
                }

            }
        }
    }

