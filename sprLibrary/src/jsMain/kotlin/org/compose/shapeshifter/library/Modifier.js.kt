package org.compose.shapeshifter.library

import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import org.jetbrains.compose.web.css.percent

actual typealias ModifierSpr = Modifier

actual object ModifierFactory {
    actual operator fun invoke(): ModifierSpr = Modifier

}

actual fun ModifierSpr.fillMaxSizeSpr(fraction: Float): ModifierSpr = fillMaxSize((fraction * 100).percent)

actual fun ModifierSpr.background(color: Color): ModifierSpr = backgroundColor(color.toKobweb())