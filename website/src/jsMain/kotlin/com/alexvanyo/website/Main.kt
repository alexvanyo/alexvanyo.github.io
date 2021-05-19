package com.alexvanyo.website

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.alexvanyo.website.data.websiteJson
import com.alexvanyo.website.models.Article
import com.alexvanyo.website.styles.FontVariantCaps
import com.alexvanyo.website.styles.fontFamily
import com.alexvanyo.website.styles.fontVariant
import com.alexvanyo.website.pages.IndexPage
import com.alexvanyo.website.styles.Colors
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.builtins.ListSerializer

fun main() {
    renderComposable(rootElementId = "root") {
        var articles by remember { mutableStateOf<List<Article>>(emptyList()) }

        LaunchedEffect(Unit) {
            val articlesJson = window.fetch("data/articles.json").await().text().await()
            articles = websiteJson.decodeFromString(ListSerializer(Article.serializer()), articlesJson)
        }

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

        IndexPage(articles)
    }
}
