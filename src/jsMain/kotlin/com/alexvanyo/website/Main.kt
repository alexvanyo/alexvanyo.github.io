package com.alexvanyo.website

import androidx.compose.web.css.Color
import androidx.compose.web.css.Style
import androidx.compose.web.css.StyleSheet
import androidx.compose.web.css.backgroundColor
import androidx.compose.web.css.color
import androidx.compose.web.css.fontSize
import androidx.compose.web.css.margin
import androidx.compose.web.css.minHeight
import androidx.compose.web.css.px
import androidx.compose.web.css.rem
import androidx.compose.web.css.vh
import androidx.compose.web.renderComposable
import com.alexvanyo.website.styles.FontVariantCaps
import com.alexvanyo.website.styles.fontFamily
import com.alexvanyo.website.styles.fontVariant
import com.alexvanyo.website.pages.IndexPage
import com.alexvanyo.website.styles.Colors

fun main() {
    renderComposable(rootElementId = "root") {
        Style(object : StyleSheet() {
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
        })

        IndexPage()
    }
}
