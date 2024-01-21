package org.compose.shapeshifter.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

actual typealias ColumnScopeSpr = ColumnScope

@Composable
actual fun ColumnSpr(
    modifier: ModifierSpr,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable ColumnScope.() -> Unit
) = Column(modifier, verticalArrangement, horizontalAlignment, content)