package com.alexvanyo.website.styles

import androidx.compose.web.css.StyleSheet
import androidx.compose.web.css.backgroundColor
import androidx.compose.web.css.color
import androidx.compose.web.css.fontSize
import androidx.compose.web.css.margin
import androidx.compose.web.css.minHeight
import androidx.compose.web.css.px
import androidx.compose.web.css.rem
import androidx.compose.web.css.vh

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
            fontSize(3.rem)
        }
    }
}
