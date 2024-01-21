package org.compose.shapeshifter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import org.compose.shapeshifter.library.ColumnSpr
import org.compose.shapeshifter.library.ModifierFactory
import org.compose.shapeshifter.library.TextSpr
import org.compose.shapeshifter.library.background
import org.compose.shapeshifter.library.fillMaxSizeSpr

@Composable
fun Example() {
    ColumnSpr(
        ModifierFactory().fillMaxSizeSpr().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextSpr("Hello world!", color = Color.Magenta)
    }
}