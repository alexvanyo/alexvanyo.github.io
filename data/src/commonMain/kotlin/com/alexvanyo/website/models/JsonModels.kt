package com.alexvanyo.website.models

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title: String,
    val url: String,
    val imageUrl: String,
)
