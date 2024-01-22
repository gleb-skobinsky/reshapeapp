package org.compose.shapeshifter.library

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLElement

external fun require(module: String): dynamic

val uuid = require("uuid")

fun uuid4(): String = uuid.v4() as String

@Composable
actual fun AnimatedVisibilitySpr(
    visible: Boolean,
    modifier: ModifierSpr,
    enter: EnterTransitionData,
    exit: ExitTransitionData,
    content: @Composable () -> Unit
) {
    var height: Int? by remember {
        mutableStateOf(null)
    }
    val id = remember {
        uuid4()
    }
    var internalVisible by remember { mutableStateOf(visible) }
    LaunchedEffect(visible) {
        if (!visible) {
            delay(exit.duration.toLong())
            internalVisible = false
        } else {
            internalVisible = true
        }
    }
    Column(
        modifier
            .attrsModifier {
                attr("id", id)
            }
            .transition(
                CSSTransition("height", enter.duration.ms),
                CSSTransition("scale", enter.duration.ms),
                CSSTransition("opacity", enter.duration.ms)
            )
            .run {
                var localModifier = this
                for (trans in enter.transitionSpec) {
                    localModifier = localModifier.toTransition(trans, visible, height)
                }
                localModifier
            }
    ) {
        if (internalVisible) {
            content()
        }
    }
    LaunchedEffect(internalVisible) {
        if (internalVisible && height == null) {
            (document.getElementById(id) as? HTMLElement)?.let {
                height = window.getComputedStyle(
                    it
                ).height.replace("px", "").toInt()
            }
        }
    }
}


fun Modifier.toTransition(
    enter: EnterAnimationTypes,
    visible: Boolean,
    height: Int?
): Modifier {
    return when (enter) {
        is EnterAnimationTypes.ExpandIn -> {
            overflow(Overflow.Hidden)
                .then(
                    if (visible) {
                        when (height) {
                            null -> height(Height.FitContent)
                            else -> height(height.px)
                        }
                    } else height(0.px)
                )
        }

        is EnterAnimationTypes.ScaleIn -> {
            scale(if (visible) 100.percent else 0.percent)
        }

        is EnterAnimationTypes.FadeIn -> {
            opacity(if (visible) 100.percent else 0.percent)
        }
    }

}


