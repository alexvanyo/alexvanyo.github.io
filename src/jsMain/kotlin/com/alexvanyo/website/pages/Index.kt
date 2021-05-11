package com.alexvanyo.website.pages

import androidx.compose.runtime.*
import androidx.compose.web.css.padding
import androidx.compose.web.css.px
import androidx.compose.web.elements.Button
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.Span
import androidx.compose.web.elements.Text

@Composable
fun IndexPage() {
    var count by remember { mutableStateOf(0) }

    Div(style = { padding(25.px) }) {
        Button(attrs = {
            onClick { count -= 1 }
        }) {
            Text("-")
        }

        Span(style = { padding(15.px) }) {
            Text("$count")
        }

        Button(attrs = {
            onClick { count += 1 }
        }) {
            Text("+")
        }
    }
}
