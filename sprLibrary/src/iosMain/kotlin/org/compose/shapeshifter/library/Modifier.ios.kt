package org.compose.shapeshifter.library

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

actual typealias ModifierSpr = Modifier

actual object ModifierFactory {
    actual operator fun invoke(): ModifierSpr = Modifier

}

actual fun ModifierSpr.fillMaxSizeSpr(fraction: Float): ModifierSpr = fillMaxSize(fraction)

actual fun ModifierSpr.background(color: Color): ModifierSpr = background(color)

actual fun ModifierSpr.clickableSpr(action: () -> Unit): ModifierSpr = clickable(onClick = action)