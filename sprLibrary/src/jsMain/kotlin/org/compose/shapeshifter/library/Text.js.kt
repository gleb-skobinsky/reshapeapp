package org.compose.shapeshifter.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.textOverflow
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Composable
actual fun TextSpr(
    text: String,
    modifier: ModifierSpr,
    color: Color,
    fontSize: TextUnit,
    fontStyle: FontStyle?,
    fontWeight: FontWeight?,
    fontFamily: FontFamily?,
    letterSpacing: TextUnit,
    textDecoration: TextDecoration?,
    textAlign: TextAlign?,
    lineHeight: TextUnit,
    overflow: TextOverflow,
    softWrap: Boolean,
    maxLines: Int,
    minLines: Int,
    onTextLayout: ((TextLayoutResult) -> Unit)?,
    style: TextStyle
) {
    val internalModifier = modifier.apply {
        fontStyle?.let {
            fontStyle(it.toKobweb())
        }
        fontWeight?.let {
            fontWeight(it.weight)
        }
        fontFamily?.let {
            when (it) {
                is SystemFontFamily -> fontFamily("system-ui")
                is GenericFontFamily -> fontFamily(it.name)
                else -> fontFamily("system-ui")
            }
        }
        textDecoration?.let {
            textDecorationLine(it.toKobweb())
        }
    }
    SpanText(
        text,
        internalModifier
            .color(color.toKobweb())
            .fontSize(fontSize.value.px)
            .letterSpacing(letterSpacing.value.px)
            .lineHeight(lineHeight.value)
            .textOverflow(overflow.toKobweb())
    )
}

fun FontStyle.toKobweb() = when (this) {
    FontStyle.Normal -> com.varabyte.kobweb.compose.css.FontStyle.Normal
    FontStyle.Italic -> com.varabyte.kobweb.compose.css.FontStyle.Italic
    else -> com.varabyte.kobweb.compose.css.FontStyle.Normal
}

fun TextDecoration.toKobweb() = when (this) {
    TextDecoration.None -> TextDecorationLine.None
    TextDecoration.LineThrough -> TextDecorationLine.LineThrough
    TextDecoration.Underline -> TextDecorationLine.Underline
    else -> TextDecorationLine.None
}

fun TextOverflow.toKobweb() = when (this) {
    TextOverflow.Ellipsis -> com.varabyte.kobweb.compose.css.TextOverflow.Ellipsis
    TextOverflow.Clip -> com.varabyte.kobweb.compose.css.TextOverflow.Clip
    TextOverflow.Visible -> com.varabyte.kobweb.compose.css.TextOverflow.Initial
    else -> com.varabyte.kobweb.compose.css.TextOverflow.Initial
}