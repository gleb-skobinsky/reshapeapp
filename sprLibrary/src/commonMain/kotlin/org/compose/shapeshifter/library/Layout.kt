package org.compose.shapeshifter.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

expect interface ColumnScopeSpr

@Composable
expect fun ColumnSpr(
    modifier: ModifierSpr = ModifierFactory(),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScopeSpr.() -> Unit
)