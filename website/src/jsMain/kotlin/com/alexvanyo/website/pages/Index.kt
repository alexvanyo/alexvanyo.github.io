package com.alexvanyo.website.pages

import androidx.compose.runtime.Composable
import androidx.compose.web.css.AlignItems
import androidx.compose.web.css.DisplayStyle
import androidx.compose.web.css.FlexDirection
import androidx.compose.web.css.FlexWrap
import androidx.compose.web.css.JustifyContent
import androidx.compose.web.css.LineStyle
import androidx.compose.web.css.alignItems
import androidx.compose.web.css.backgroundColor
import androidx.compose.web.css.border
import androidx.compose.web.css.borderRadius
import androidx.compose.web.css.color
import androidx.compose.web.css.display
import androidx.compose.web.css.flexDirection
import androidx.compose.web.css.flexGrow
import androidx.compose.web.css.flexShrink
import androidx.compose.web.css.flexWrap
import androidx.compose.web.css.height
import androidx.compose.web.css.justifyContent
import androidx.compose.web.css.marginTop
import androidx.compose.web.css.padding
import androidx.compose.web.css.percent
import androidx.compose.web.css.px
import androidx.compose.web.css.rem
import androidx.compose.web.css.value
import androidx.compose.web.css.vh
import androidx.compose.web.css.width
import androidx.compose.web.elements.A
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.Footer
import androidx.compose.web.elements.H1
import androidx.compose.web.elements.H3
import androidx.compose.web.elements.H4
import androidx.compose.web.elements.Img
import androidx.compose.web.elements.P
import androidx.compose.web.elements.Section
import androidx.compose.web.elements.Text
import com.alexvanyo.website.data.Platform
import com.alexvanyo.website.data.platforms
import com.alexvanyo.website.models.Article
import com.alexvanyo.website.styles.Colors
import com.alexvanyo.website.styles.TextAlign
import com.alexvanyo.website.styles.textAlign

@Composable
fun IndexPage(
    articles: List<Article>
) {
    Div(style = {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        property("min-height", value(100.vh))
        justifyContent(JustifyContent.Center)
    }) {

        WebsiteHeader()

        Div(
            style = {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
            }
        ) {
            Div(style = {
                property("flex-basis", value(100.rem))
                flexGrow(0)
                flexShrink(1)
                padding(2.rem)
                display(DisplayStyle.Grid)
                property("grid-gap", value("1rem"))
                property("grid-template-columns", value("repeat(auto-fit, minmax(min(30rem, 100%), 1fr))"))
            }) {
                articles.forEach { article ->
                    WebsiteArticle(article)
                }
            }
        }

        Div(
            style = {
                flexGrow(1)
            }
        ) {
            
        }

        WebsiteFooter()
    }
}

@Composable
fun WebsiteArticle(article: Article) {
    A(
        href = article.url,
        style = {
            property("text-decoration", value("none"))
        }
    ) {
        Div(
            style = {
                backgroundColor(Colors.primary)
                padding(1.rem)
                borderRadius(1.rem)
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
                property("gap", value("1rem"))
            }
        ) {
            Img(
                src = article.imageUrl,
                style = {
                    height(10.rem)
                }
            )

            H3(
                style = {
                    color(Colors.textOnPrimary)
                    marginTop(0.px)
                    property("margin-bottom", value(0.px))
                    textAlign(TextAlign.Center)
                }
            ) {
                Text(article.title)
            }
        }
    }
}

@Composable
fun WebsiteHeader() {
    Section(
        style = {
            backgroundColor(Colors.elevatedBackground)
            textAlign(TextAlign.Center)
            padding(2.rem)
        }
    ) {
        Img(
            src = "img/alex-vanyo.jpg",
            style = {
                property("object-fit", value("cover"))
                borderRadius(50.percent)
                height(10.rem)
                width(10.rem)
                border {
                    style(LineStyle.Solid)
                    width(0.3.rem)
                    color(Colors.primary)
                }
            },
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
    Footer(
        style = {
            backgroundColor(Colors.elevatedBackground)
            padding(2.rem)
            textAlign(TextAlign.Center)
            display(DisplayStyle.Flex)
            flexWrap(FlexWrap.Wrap)
            flexDirection(FlexDirection.Row)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            property("gap", value("1rem"))
        }
    ) {
        platforms.forEach { platform ->
            PlatformLink(platform)
        }
    }
}

@Composable
fun PlatformLink(platform: Platform) {
    A(
        href = platform.url,
        style = {
            property("text-decoration", value("none"))
        }
    ) {
        Div(
            style = {
                backgroundColor(Colors.primary)
                padding(1.rem)
                borderRadius(1.rem)
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                flexDirection(FlexDirection.Row)
                alignItems(AlignItems.Center)
                property("gap", value("1rem"))
            }
        ) {
            Img(
                src = platform.icon,
                style = {
                    height(2.rem)
                    width(2.rem)
                    display(DisplayStyle.Inline)
                }
            )

            H4(
                style = {
                    display(DisplayStyle.Inline)
                    color(Colors.textOnPrimary)
                    marginTop(0.px)
                    property("margin-bottom", value(0.px))
                }
            ) {
                Text(platform.name)
            }
        }
    }
}
