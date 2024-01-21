package org.compose.shapeshifter.library

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.web.css.CSSColorValue

fun Color.toKobweb(): CSSColorValue = org.jetbrains.compose.web.css.rgba(red, green, blue, alpha)