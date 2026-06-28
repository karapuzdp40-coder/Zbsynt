package com.absynth.hostel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AbsinthGreen,
    onPrimary = GoldPrimary,
    secondary = GoldPrimary,
    onSecondary = AbsinthGreen,
    tertiary = AbsinthGreenLight,
    onTertiary = Color.White,
    background = DarkBackground,
    onBackground = Color.White,
    surface = DarkBackgroundSecond,
    onSurface = Color.White,
    error = ErrorRed,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = AbsinthGreen,
    onPrimary = Color.White,
    secondary = GoldPrimary,
    onSecondary = Color.White,
    tertiary = AbsinthGreenLight,
    onTertiary = Color.White,
    background = Cream,
    onBackground = DarkText,
    surface = Color.White,
    onSurface = DarkText,
    error = ErrorRed,
    onError = Color.White
)

@Composable
fun AbysynthTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}