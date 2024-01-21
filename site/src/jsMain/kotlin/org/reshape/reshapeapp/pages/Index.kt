package org.reshape.shapeshifter.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.reshape.shapeshifter.modifier.fillWidthUntilPadding

@Page
@Composable
@Suppress("UNUSED")
fun HomePage() {
    Column(
        modifier = Modifier
            .margin(20.px)
            .fillWidthUntilPadding(20.px)
            .borderRadius(20.px)
            .backgroundColor(Colors.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var imageVisible by remember { mutableStateOf(false) }
        Image(
            "/kobweb-logo.png", modifier = Modifier
                .opacity(if (imageVisible) 100 else 0)
                .transition(CSSTransition("opacity", 500.ms))
        )
        Column(
            Modifier
                .borderRadius(12.px)
                .backgroundColor(Colors.White)
                .boxShadow(
                    5.px,
                    5.px,
                    blurRadius = 5.px,
                    color = Colors.Black.copy(alpha = 100)
                )
                .padding(left = 20.px, right = 20.px)
                .onClick {
                    imageVisible = !imageVisible
                }
                .cursor(Cursor.Pointer)
                .margin(top = 20.px)
        ) {
            SpanText(
                text = "Hello world!",
                modifier = Modifier
                    .color(Colors.Black)
            )
        }
    }
}
