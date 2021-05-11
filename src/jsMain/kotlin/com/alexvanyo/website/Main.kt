package com.alexvanyo.website

import androidx.compose.web.renderComposable
import com.alexvanyo.website.pages.IndexPage

fun main() {
    renderComposable(rootElementId = "root") {
        IndexPage()
    }
}
