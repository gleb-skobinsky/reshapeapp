package org.reshape.shapeshifter.modifier

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.times

fun <T : CSSUnit> Modifier.fillWidthUntilPadding(padding: CSSSizeValue<T>) = styleModifier {
    property("width", 100.percent.unsafeCast<CSSSizeValue<CSSUnit>>() - (padding * 2))
}