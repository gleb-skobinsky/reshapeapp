package org.compose.shapeshifter.library

import androidx.compose.runtime.Composable

@Composable
actual fun AnimatedVisibilitySpr(
    visible: Boolean,
    modifier: ModifierSpr,
    enter: EnterTransitionData,
    exit: ExitTransitionData,
    content: @Composable () -> Unit
) = CommonAnimatedVisibilitySpr(visible, modifier, enter, exit, content)