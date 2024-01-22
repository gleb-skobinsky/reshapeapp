package org.compose.shapeshifter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import org.compose.shapeshifter.library.AnimatedVisibilitySpr
import org.compose.shapeshifter.library.ColumnSpr
import org.compose.shapeshifter.library.ModifierFactory
import org.compose.shapeshifter.library.TextSpr
import org.compose.shapeshifter.library.background
import org.compose.shapeshifter.library.clickableSpr
import org.compose.shapeshifter.library.fillMaxSizeSpr

@Composable
fun Example() {
    var textVisible by remember { mutableStateOf(false) }
    ColumnSpr(
        ModifierFactory().fillMaxSizeSpr().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibilitySpr(textVisible) {
            TextSpr(
                text = "Hello world!",
                color = Color.Magenta,
                fontSize = 80.sp
            )
        }
        TextSpr(
            text = if (textVisible) "Hide" else "Display",
            color = Color.Magenta,
            fontSize = 48.sp,
            modifier = ModifierFactory().clickableSpr {
                println("Click")
                textVisible = !textVisible
            }
        )
    }
}