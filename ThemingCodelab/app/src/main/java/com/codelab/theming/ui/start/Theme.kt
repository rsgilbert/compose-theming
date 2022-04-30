package com.codelab.theming.ui.start

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColors(
    primary = Red700,
    primaryVariant = Red900,
    background = Color.White,
    surface = Color.White,
    error = Red800,
    onPrimary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White
)

private val DarkColors = lightColors(
    primary = Red300,
    primaryVariant = Red700,
    background = Color.Black,
    surface = Color.Black,
    error = Red200,
    onPrimary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Black
)

@Composable
fun JetnewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit) {
    val cols = if(darkTheme) DarkColors else LightColors
    MaterialTheme(
        colors = cols,
        typography = JetnewsTypography,
        shapes = JetnewsShapes
    ) {
        content()
    }
}