package com.codelab.theming.ui.start

import androidx.compose.material.MaterialTheme
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


@Composable
fun JetnewsTheme(content: @Composable () -> Unit) {
//    MaterialTheme(
//        content = content
//    )
    MaterialTheme(
        colors = LightColors,
        typography = JetnewsTypography
    ) {
        content()
    }
}