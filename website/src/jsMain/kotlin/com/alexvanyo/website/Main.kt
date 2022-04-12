package com.alexvanyo.website

import com.alexvanyo.website.pages.IndexPage
import com.alexvanyo.website.styles.MainStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(MainStylesheet)
        IndexPage()
    }
}
