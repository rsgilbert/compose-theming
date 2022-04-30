package com.codelab.theming.ui.start

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val JetnewsShapes = Shapes(
    small = CutCornerShape(topStart = 8.dp, topEnd = 30.dp),
    medium = CutCornerShape(topStart = 8.dp, bottomStart = 16.dp, bottomEnd = 20.dp, topEnd = 48.dp),
    large = CutCornerShape(topStart = 8.dp, bottomEnd = 16.dp, topEnd = 32.dp)
)