package com.alexvanyo.website

import com.alexvanyo.website.pages.BackstackPage
import com.alexvanyo.website.pages.IndexPage
import com.alexvanyo.website.styles.MainStylesheet
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.url.URLSearchParams

fun main() {
    renderComposable(rootElementId = "root") {
        Style(MainStylesheet)

        val params = URLSearchParams(window.location.search)

        val testParam = params.get("test")

        if (testParam == "backstack") {
            BackstackPage()
        } else {
            IndexPage()
        }
    }
}
