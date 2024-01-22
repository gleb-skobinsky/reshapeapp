package org.compose.shapeshifter.library

import androidx.compose.ui.graphics.Color

expect interface ModifierSpr

expect object ModifierFactory {
    operator fun invoke(): ModifierSpr
}

expect fun ModifierSpr.fillMaxSizeSpr(fraction: Float = 1f): ModifierSpr

expect fun ModifierSpr.background(color: Color): ModifierSpr

expect fun ModifierSpr.clickableSpr(action: () -> Unit): ModifierSpr