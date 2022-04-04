package com.alexvanyo.website.styles

import org.jetbrains.compose.web.css.CSSBuilder
import org.jetbrains.compose.web.css.CSSStyleRuleBuilder
import org.jetbrains.compose.web.css.StyleScope

fun CSSBuilder.fontFamily(value: String) {
    property("font-family", value)
}

fun CSSStyleRuleBuilder.fontFamily(value: String) {
    property("font-family", value)
}

fun CSSStyleRuleBuilder.fontVariant(fontVariantCaps: FontVariantCaps) {
    property("font-variant", fontVariantCaps.value)
}

enum class FontVariantCaps(val value: String) {
    Normal("normal"),
    SmallCaps("small-caps"),
    AllSmallCaps("all-small-caps"),
    PetiteCaps("petite-caps"),
    AllPetiteCaps("all-petite-caps"),
    Unicase("unicase"),
    TitlingCaps("titling-caps"),
}

fun StyleScope.textAlign(textAlign: TextAlign) {
    property("text-align", textAlign.value)
}

enum class TextAlign(val value: String) {
    Left("left"),
    Right("right"),
    Center("center"),
    Justify("justify"),
    Initial("initial"),
    Inherit("inherit"),
}
