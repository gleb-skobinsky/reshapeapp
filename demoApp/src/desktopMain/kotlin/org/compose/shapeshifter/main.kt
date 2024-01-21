package org.compose.shapeshifter

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "ComposeShapeshifter") {
        Example()
    }
}

@Preview
@Composable
@Suppress("Unused")
fun AppDesktopPreview() {
    Example()
}