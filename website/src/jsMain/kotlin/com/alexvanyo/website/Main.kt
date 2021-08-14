package com.alexvanyo.website

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.alexvanyo.website.data.websiteJson
import com.alexvanyo.website.models.Article
import com.alexvanyo.website.pages.BackstackPage
import com.alexvanyo.website.pages.IndexPage
import com.alexvanyo.website.styles.MainStylesheet
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.builtins.ListSerializer
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.url.URLSearchParams

fun main() {
    renderComposable(rootElementId = "root") {
        var articles by remember { mutableStateOf<List<Article>>(emptyList()) }

        LaunchedEffect(Unit) {
            val articlesJson = window.fetch("data/articles.json").await().text().await()
            articles = websiteJson.decodeFromString(ListSerializer(Article.serializer()), articlesJson)
        }

        Style(MainStylesheet)

        val params = URLSearchParams(window.location.search)

        val testParam = params.get("test")

        if (testParam == "backstack") {
            BackstackPage()
        } else {
            IndexPage(articles)
        }
    }
}
