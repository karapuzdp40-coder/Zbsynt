package com.absynth.hostel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.absynth.hostel.ui.screens.HomeScreen
import com.absynth.hostel.ui.screens.RoomsScreen
import com.absynth.hostel.ui.screens.ProfileScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        
        composable("rooms") {
            RoomsScreen(navController)
        }
        
        composable("profile") {
            ProfileScreen(navController)
        }
    }
}