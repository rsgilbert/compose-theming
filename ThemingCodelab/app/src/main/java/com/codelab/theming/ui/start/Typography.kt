package com.codelab.theming.ui.start

import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codelab.theming.R


private val Montserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
)

 val Domine = FontFamily(
    Font(R.font.domine_regular, FontWeight.Normal),
    Font(R.font.domine_bold, FontWeight.Bold)
)

val JetnewsTypography = Typography(
    h4 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold
    ),
    h5 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold,
    ),
    h6 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold
    ),
    subtitle1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold
    ),
    subtitle2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium
    ),
    body1 = TextStyle(
        fontFamily = Domine,
        fontWeight = FontWeight.Normal
    ),
    body2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium
    ),
    button = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold
    ),
    caption = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium
    ),
    overline = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold
    )
)
