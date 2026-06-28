package com.absynth.hostel.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AbsyntColorScheme = lightColorScheme(
    primary = TealPrimary,
    onPrimary = Snow,
    primaryContainer = TealPale,
    onPrimaryContainer = TealDeep,
    secondary = Sand,
    onSecondary = Charcoal,
    secondaryContainer = SandLight,
    onSecondaryContainer = Charcoal,
    tertiary = TealMid,
    onTertiary = Snow,
    background = Cream,
    onBackground = InkText,
    surface = Snow,
    onSurface = InkText,
    surfaceVariant = TealPale,
    onSurfaceVariant = MutedText,
    error = ErrorRed,
    onError = Snow
)

@Composable
fun AbsyntTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AbsyntColorScheme,
        typography = Typography,
        content = content
    )
}
