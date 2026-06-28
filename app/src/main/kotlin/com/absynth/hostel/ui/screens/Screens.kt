package com.absynth.hostel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.absynth.hostel.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(AbsinthGreen, AbsinthGreenDark)
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "ABSYNTH",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = GoldPrimary,
                    letterSpacing = 3.sp
                )
                Text(
                    "HOSTEL",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    letterSpacing = 2.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "Experience Creative Vibes",
                    fontSize = 14.sp,
                    color = GoldLight,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { navController.navigate("rooms") },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GoldPrimary
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "Book Your Bed",
                        color = AbsinthGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Why Choose Absynth?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = AbsinthGreen,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            repeat(4) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = null,
                            tint = AbsinthGreen,
                            modifier = Modifier.size(24.dp)
                        )
                        Column {
                            Text(
                                "Feature ${it + 1}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = AbsinthGreen
                            )
                            Text(
                                "Amazing description here",
                                fontSize = 12.sp,
                                color = MediumText
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun RoomsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {
        TopAppBar(
            title = { Text("Available Rooms", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = AbsinthGreen,
                titleContentColor = Color.White
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            repeat(5) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(bottom = 12.dp)
                        .clickable { },
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .fillMaxHeight()
                                .background(AbsinthGreen)
                        ) {
                            Icon(
                                Icons.Filled.Hotel,
                                contentDescription = null,
                                tint = GoldPrimary,
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(Alignment.Center)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(12.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    "Room ${index + 1}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = AbsinthGreen
                                )
                                Text(
                                    "Premium accommodation",
                                    fontSize = 11.sp,
                                    color = MediumText
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    repeat(5) {
                                        Icon(
                                            Icons.Filled.Star,
                                            contentDescription = null,
                                            tint = GoldPrimary,
                                            modifier = Modifier.size(12.dp)
                                        )
                                    }
                                    Text("4.8", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                }

                                Text(
                                    "€${25 + index * 5}/night",
                                    fontWeight = FontWeight.Bold,
                                    color = AbsinthGreen,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {
        TopAppBar(
            title = { Text("My Profile", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = AbsinthGreen,
                titleContentColor = Color.White
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(50),
                color = GoldPrimary
            ) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp),
                    tint = AbsinthGreen
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Guest User",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = AbsinthGreen
            )
            Text(
                "guest@absynth.com",
                fontSize = 12.sp,
                color = MediumText,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            repeat(3) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = null,
                                tint = AbsinthGreen,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                "Setting ${it + 1}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = AbsinthGreen
                            )
                        }
                        Icon(
                            Icons.Filled.ChevronRight,
                            contentDescription = null,
                            tint = MediumText,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
