package org.compose.shapeshifter.library

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize

fun defDuration() = 300

sealed interface EnterAnimationTypes {

    val duration: Int
    val spec: FiniteAnimationSpec<*>

    class ExpandIn(
        override val duration: Int = defDuration(),
        override val spec: FiniteAnimationSpec<IntSize>
    ) : EnterAnimationTypes

    class FadeIn(
        override val duration: Int = defDuration(),
        override val spec: FiniteAnimationSpec<Float>
    ) : EnterAnimationTypes

    class ScaleIn(
        override val duration: Int = defDuration(),
        override val spec: FiniteAnimationSpec<Float>
    ) : EnterAnimationTypes

    fun toCompose(): EnterTransition = when (this) {
        is ExpandIn -> expandIn(spec)
        is FadeIn -> fadeIn(spec)
        is ScaleIn -> scaleIn(spec)
    }
}

sealed interface ExitAnimationTypes {

    val duration: Int
    val spec: FiniteAnimationSpec<*>

    class ShrinkOut(
        override val duration: Int = defDuration(),
        override val spec: FiniteAnimationSpec<IntSize>
    ) : ExitAnimationTypes

    class FadeOut(
        override val duration: Int = defDuration(),
        override val spec: FiniteAnimationSpec<Float>
    ) : ExitAnimationTypes

    class ScaleOut(
        override val duration: Int = defDuration(),
        override val spec: FiniteAnimationSpec<Float>
    ) : ExitAnimationTypes

    fun toCompose(): ExitTransition = when (this) {
        is ShrinkOut -> shrinkOut(spec)
        is FadeOut -> fadeOut(spec)
        is ScaleOut -> scaleOut(spec)
    }
}

data class EnterTransitionData(
    val transitionSpec: List<EnterAnimationTypes>,
    val duration: Int = defDuration(),
) {
    fun toComposeTransition(): EnterTransition {
        if (transitionSpec.isEmpty()) return EnterTransition.None
        return transitionSpec.map { it.toCompose() }
            .reduce { acc, enter ->
                acc + enter
            }
    }
}

data class ExitTransitionData(
    val transitionSpec: List<ExitAnimationTypes>,
    val duration: Int = defDuration(),
) {
    fun toComposeTransition(): ExitTransition {
        if (transitionSpec.isEmpty()) return ExitTransition.None
        return transitionSpec.map { it.toCompose() }
            .reduce { acc, exit ->
                acc + exit
            }
    }
}

@Composable
expect fun AnimatedVisibilitySpr(
    visible: Boolean,
    modifier: ModifierSpr = ModifierFactory(),
    enter: EnterTransitionData =
        EnterTransitionData(
            listOf(
                EnterAnimationTypes.FadeIn(spec = tween(defDuration())),
                EnterAnimationTypes.ExpandIn(spec = tween(defDuration())),
            )
        ),
    exit: ExitTransitionData = ExitTransitionData(
        listOf(
            ExitAnimationTypes.FadeOut(spec = tween(defDuration())),
            ExitAnimationTypes.ShrinkOut(spec = tween(defDuration())),
        )
    ),
    content: @Composable () -> Unit
)

@Composable
fun CommonAnimatedVisibilitySpr(
    visible: Boolean,
    modifier: Modifier,
    enter: EnterTransitionData,
    exit: ExitTransitionData,
    content: @Composable () -> Unit
) =
    AnimatedVisibility(
        visible = visible,
        modifier = modifier,
        enter = enter.toComposeTransition(),
        exit = exit.toComposeTransition(),
        label = "AnimatedVisibility"
    ) {
        content()
    }