package com.bangkit.navomobility.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bangkit.navomobility.ui.screen.track.Track
import com.bangkit.navomobility.ui.screen.history.HistoryScreen
import com.bangkit.navomobility.ui.screen.home.HomeScreen
import com.bangkit.navomobility.ui.screen.profile.ProfileScreen
import com.bangkit.navomobility.ui.screen.register.RegisterViewModel

@Composable
fun BottomNavGraph (navController: NavHostController){
    var darkTheme by remember { mutableStateOf(false) }
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }

        composable(route = BottomBarScreen.Jalan.route){
            Track()
        }

        composable(route = BottomBarScreen.History.route){
            HistoryScreen()
        }

        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen(
                registerViewModel = RegisterViewModel(),
                darkTheme = darkTheme,
                onThemeUpdated = { darkTheme = !darkTheme }
            )
        }

    }
}