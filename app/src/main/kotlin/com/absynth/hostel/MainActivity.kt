package com.absynth.hostel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.absynth.hostel.ui.AbsyntApp
import com.absynth.hostel.ui.theme.AbsyntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AbsyntTheme {
                AbsyntApp()
            }
        }
    }
}
