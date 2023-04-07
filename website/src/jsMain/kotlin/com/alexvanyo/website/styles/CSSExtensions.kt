package com.alexvanyo.website.styles

import org.jetbrains.compose.web.css.CSSStyleRuleBuilder

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
