package com.absynth.hostel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.absynth.hostel.ui.navigation.RootNavigation
import com.absynth.hostel.ui.theme.AbysynthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AbysynthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = com.absynth.hostel.ui.theme.AbsinthGreen
                ) {
                    RootNavigation()
                }
            }
        }
    }
}
