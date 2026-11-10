package com.combystile.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// ==========================================
// COLORES COMBYSTILE
// ==========================================

private val Beige = Color(0xFFF2D1B8)
private val BeigeStrong = Color(0xFFDCAE8F)

// ==========================================
// TEMA OSCURO
// ==========================================

private val DarkColorScheme = darkColorScheme(
    primary = Beige,
    onPrimary = Color(0xFF29231F),

    secondary = BeigeStrong,
    onSecondary = Color(0xFF29231F),

    background = Color(0xFF111A13),
    onBackground = Color(0xFFF6F4EF),

    surface = Color(0xFF202A21),
    onSurface = Color(0xFFF6F4EF),

    surfaceVariant = Color(0xFF263128),
    onSurfaceVariant = Color(0xFFA9AFA9),

    outline = Color(0xFF334036),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005)
)

// ==========================================
// TEMA CLARO
// ==========================================

private val LightColorScheme = lightColorScheme(
    primary = BeigeStrong,
    onPrimary = Color(0xFF29231F),

    secondary = Color(0xFF38523E),
    onSecondary = Color.White,

    background = Color(0xFFF5EFE8),
    onBackground = Color(0xFF232823),

    surface = Color.White,
    onSurface = Color(0xFF232823),

    surfaceVariant = Color(0xFFFAF7F3),
    onSurfaceVariant = Color(0xFF686E69),

    outline = Color(0xFFD9CEC5),

    error = Color(0xFFBA1A1A),
    onError = Color.White
)

// ==========================================
// TEMA GENERAL DE COMBYSTILE
// ==========================================

@Composable
fun CombystileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme =
        if (darkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}