package br.com.lucad.randomquotes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.lucad.randomquotes.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "RandomQuotes",
    ) {
        App()
    }
}