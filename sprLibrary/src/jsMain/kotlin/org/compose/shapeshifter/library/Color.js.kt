package org.compose.shapeshifter.library

import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgba
import org.jetbrains.compose.web.css.CSSColorValue

fun Color.toKobweb(): CSSColorValue = rgba(red, green, blue, alpha)