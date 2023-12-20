package com.bangkit.navomobility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.bangkit.navomobility.ui.NavGraph
import com.bangkit.navomobility.ui.screen.home.HomeTabs
import com.bangkit.navomobility.ui.screen.home.TravelAppBottomBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val tabs = remember { HomeTabs.values() }
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { TravelAppBottomBar(tabs = tabs, navController = navController) }
            ) { innerPadding ->
                NavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
