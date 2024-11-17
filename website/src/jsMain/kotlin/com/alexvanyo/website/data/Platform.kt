package com.alexvanyo.website.data

data class Platform(
    val name: String,
    val icon: String,
    val url: String,
)

val platforms = listOf(
    Platform(
        name = "Medium",
        icon = "img/medium.svg",
        url = "https://medium.com/@alexvanyo",
    ),
    Platform(
        name = "GitHub",
        icon = "img/github.png",
        url = "https://github.com/alexvanyo",
    ),
    Platform(
        name = "Mastodon",
        icon = "img/mastodon.svg",
        url = "https://androiddev.social/@alex_vanyo",
    ),
    Platform(
        name = "Bluesky",
        icon = "img/bluesky.svg",
        url = "https://bsky.app/profile/vanyo.dev",
    )
)
