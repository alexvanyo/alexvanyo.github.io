package com.alexvanyo.website.styles

import androidx.compose.web.css.CSSBuilder
import androidx.compose.web.css.CSSStyleRuleBuilder
import androidx.compose.web.css.StyleBuilder
import androidx.compose.web.css.StylePropertyValue
import androidx.compose.web.css.value

fun CSSBuilder.fontFamily(value: String) {
    property("font-family", value(value))
}

fun CSSStyleRuleBuilder.fontFamily(value: String) {
    property("font-family", value(value))
}

fun CSSStyleRuleBuilder.fontVariant(fontVariantCaps: FontVariantCaps) {
    property("font-variant", StylePropertyValue(fontVariantCaps.value))
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

fun StyleBuilder.textAlign(textAlign: TextAlign) {
    property("text-align", StylePropertyValue(textAlign.value))
}

enum class TextAlign(val value: String) {
    Left("left"),
    Right("right"),
    Center("center"),
    Justify("justify"),
    Initial("initial"),
    Inherit("inherit"),
}
