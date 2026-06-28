package com.absynth.hostel.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.absynth.hostel.ui.screens.ContactScreen
import com.absynth.hostel.ui.screens.HomeScreen
import com.absynth.hostel.ui.screens.RoomsScreen
import com.absynth.hostel.ui.theme.Snow
import com.absynth.hostel.ui.theme.TealDeep
import com.absynth.hostel.ui.theme.TealPrimary

private enum class Dest(val route: String, val label: String, val icon: ImageVector) {
    Home("home", "Hostel", Icons.Filled.Hotel),
    Rooms("rooms", "Pokoje", Icons.Outlined.Bed),
    Contact("contact", "Kontakt", Icons.Outlined.Place),
}

@Composable
fun AbsyntApp() {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentDest = backStack?.destination

    Scaffold(
        containerColor = com.absynth.hostel.ui.theme.Cream,
        bottomBar = {
            NavigationBar(containerColor = Snow, tonalElevation = 6.dp) {
                Dest.entries.forEach { dest ->
                    val selected = currentDest?.hierarchy?.any { it.route == dest.route } == true
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(dest.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(dest.icon, contentDescription = dest.label) },
                        label = { Text(dest.label, fontSize = 12.sp, fontWeight = FontWeight.SemiBold) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Snow,
                            selectedTextColor = TealDeep,
                            indicatorColor = TealPrimary,
                            unselectedIconColor = com.absynth.hostel.ui.theme.MutedText,
                            unselectedTextColor = com.absynth.hostel.ui.theme.MutedText,
                        )
                    )
                }
            }
        }
    ) { inner ->
        NavHost(
            navController = navController,
            startDestination = Dest.Home.route,
            modifier = Modifier.padding(inner)
        ) {
            composable(Dest.Home.route) { HomeScreen(onBook = { navController.navigate(Dest.Rooms.route) }) }
            composable(Dest.Rooms.route) { RoomsScreen() }
            composable(Dest.Contact.route) { ContactScreen() }
        }
    }
}
