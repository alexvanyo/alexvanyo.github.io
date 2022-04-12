package com.alexvanyo.website.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import com.alexvanyo.website.data.Platform
import com.alexvanyo.website.data.platforms
import com.alexvanyo.website.data.websiteJson
import com.alexvanyo.website.models.Article
import com.alexvanyo.website.styles.Colors
import com.alexvanyo.website.styles.TextAlign
import com.alexvanyo.website.styles.textAlign
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.builtins.ListSerializer
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.flexGrow
import org.jetbrains.compose.web.css.flexShrink
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.style
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

@Composable
fun IndexPage() {
    val articles by produceState(emptyList<Article>()) {
        val articlesJson = window.fetch("data/articles.json").await().text().await()
        value = websiteJson.decodeFromString(ListSerializer(Article.serializer()), articlesJson)
    }
    IndexPage(articles)
}

@Composable
fun IndexPage(
    articles: List<Article>
) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            property("min-height", 100.vh)
            justifyContent(JustifyContent.Center)
        }
    }) {

        WebsiteHeader()

        Div({
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
            }
        }) {
            Div({
                style {
                    property("flex-basis", 80.cssRem)
                    flexGrow(0)
                    flexShrink(1)
                    padding(2.cssRem)
                    display(DisplayStyle.Grid)
                    property("grid-gap", 1.cssRem)
                    property("grid-template-columns", "repeat(auto-fit, minmax(min(20rem, 100%), 1fr))")
                }
            }) {
                articles.forEach { article ->
                    WebsiteArticle(article)
                }
            }
        }

        Div({
            style {
                flexGrow(1)
            }
        }) {
        }

        WebsiteFooter()
    }
}

@Composable
fun WebsiteArticle(article: Article) {
    A(
        href = article.url,
        attrs = {
            style {
                property("text-decoration", "none")
            }
        }
    ) {
        Div({
            style {
                backgroundColor(Colors.primary)
                padding(1.cssRem)
                borderRadius(1.cssRem)
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
                property("gap", 1.cssRem)
            }
        }) {
            Img(
                src = article.imageUrl,
                attrs = {
                    style {
                        height(10.cssRem)
                        width(100.percent)
                        property("object-fit", "contain")
                    }
                }
            )

            H3({
                style {
                    color(Colors.textOnPrimary)
                    marginTop(0.px)
                    property("margin-bottom", 0.px)
                    textAlign(TextAlign.Center)
                }
            }) {
                Text(article.title)
            }
        }
    }
}

@Composable
fun WebsiteHeader() {
    Section({
        style {
            backgroundColor(Colors.elevatedBackground)
            textAlign(TextAlign.Center)
            padding(2.cssRem)
        }
    }) {
        Img(
            src = "img/alex-vanyo.jpg",
            attrs = {
                style {
                    property("object-fit", "cover")
                    borderRadius(50.percent)
                    height(10.cssRem)
                    width(10.cssRem)
                    border {
                        style(LineStyle.Solid)
                        width(0.3.cssRem)
                        color(Colors.primary)
                    }
                }
            }
        )

        H1 {
            Text("Alex Vanyo")
        }
        P {
            Text("I'm an Android software engineer who loves to tinker with code and code-writing code.")
        }
    }
}

@Composable
fun WebsiteFooter() {
    Footer({
        style {
            backgroundColor(Colors.elevatedBackground)
            padding(2.cssRem)
            textAlign(TextAlign.Center)
            display(DisplayStyle.Flex)
            flexWrap(FlexWrap.Wrap)
            flexDirection(FlexDirection.Row)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            property("gap", 1.cssRem)
        }
    }) {
        platforms.forEach { platform ->
            PlatformLink(platform)
        }
    }
}

@Composable
fun PlatformLink(platform: Platform) {
    A(
        href = platform.url,
        attrs = {
            style {
                property("text-decoration", "none")
            }
        }
    ) {
        Div({
            style {
                backgroundColor(Colors.primary)
                padding(1.cssRem)
                borderRadius(1.cssRem)
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                flexDirection(FlexDirection.Row)
                alignItems(AlignItems.Center)
                property("gap", 1.cssRem)
            }
        }) {
            Img(
                src = platform.icon,
                attrs = {
                    style {
                        height(2.cssRem)
                        width(2.cssRem)
                        display(DisplayStyle.Inline)
                    }
                }
            )

            H4({
                style {
                    display(DisplayStyle.Inline)
                    color(Colors.textOnPrimary)
                    marginTop(0.px)
                    property("margin-bottom", 0.px)
                }
            }) {
                Text(platform.name)
            }
        }
    }
}
