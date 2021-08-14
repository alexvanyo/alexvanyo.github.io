package com.alexvanyo.website.styles

import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

object MainStylesheet : StyleSheet() {
    init {
        "body" style {
            backgroundColor(Colors.background)
            color(Colors.textOnBackground)
            fontFamily("'Roboto', serif")
            margin(0.px)
            minHeight(100.vh)
        }

        "h1" style {
            fontVariant(FontVariantCaps.SmallCaps)
            fontSize(3.cssRem)
        }
    }
}
