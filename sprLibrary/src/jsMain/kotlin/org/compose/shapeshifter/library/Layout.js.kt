package org.compose.shapeshifter.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.varabyte.kobweb.compose.foundation.layout.Column

actual typealias ColumnScopeSpr = com.varabyte.kobweb.compose.foundation.layout.ColumnScope

@Composable
actual fun ColumnSpr(
    modifier: ModifierSpr,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable ColumnScopeSpr.() -> Unit
) = Column(
    modifier,
    verticalArrangement.toKobweb(),
    horizontalAlignment.toKobweb(),
    content = content
)


fun Arrangement.Vertical.toKobweb(): com.varabyte.kobweb.compose.foundation.layout.Arrangement.Vertical {
    return when (this) {
        Arrangement.Top -> com.varabyte.kobweb.compose.foundation.layout.Arrangement.Top
        Arrangement.Bottom -> com.varabyte.kobweb.compose.foundation.layout.Arrangement.Bottom
        Arrangement.Center -> com.varabyte.kobweb.compose.foundation.layout.Arrangement.Center
        Arrangement.SpaceAround -> com.varabyte.kobweb.compose.foundation.layout.Arrangement.SpaceAround
        Arrangement.SpaceBetween -> com.varabyte.kobweb.compose.foundation.layout.Arrangement.SpaceBetween
        Arrangement.SpaceEvenly -> com.varabyte.kobweb.compose.foundation.layout.Arrangement.SpaceEvenly
        else -> com.varabyte.kobweb.compose.foundation.layout.Arrangement.Top
    }
}

fun Alignment.Horizontal.toKobweb(): com.varabyte.kobweb.compose.ui.Alignment.Horizontal {
    return when (this) {
        Alignment.CenterHorizontally -> com.varabyte.kobweb.compose.ui.Alignment.CenterHorizontally
        Alignment.Start -> com.varabyte.kobweb.compose.ui.Alignment.Start
        Alignment.End -> com.varabyte.kobweb.compose.ui.Alignment.End
        else -> com.varabyte.kobweb.compose.ui.Alignment.Start
    }
}