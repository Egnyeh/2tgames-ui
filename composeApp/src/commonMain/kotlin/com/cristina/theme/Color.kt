package com.cristina.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

// Colores personalizados negro y morado
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// Colores principales
val PrimaryPurple = Color(0xFF9C27B0)  // Morado principal
val SecondaryPurple = Color(0xFFBA68C8)  // Morado claro
val DarkPurple = Color(0xFF7B1FA2)  // Morado oscuro
val Black = Color(0xFF000000)
val DarkGray = Color(0xFF1A1A1A)
val MediumGray = Color(0xFF2D2D2D)

val AppColorScheme = darkColorScheme(
    primary = PrimaryPurple,
    secondary = SecondaryPurple,
    tertiary = Pink80,
    background = Black,
    surface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black
)
