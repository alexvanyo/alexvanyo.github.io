package com.alexvanyo.website.datasync.models

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("rss", "", "")
data class RssFeed(
    val channel: RssChannel
)

@Serializable
@XmlSerialName("channel", "", "")
data class RssChannel(
    val items: List<RssItem>,
)

@Serializable
@XmlSerialName("item", "", "")
data class RssItem(
    @XmlElement(true)
    @XmlSerialName("title", "", "")
    val title: String,
    @XmlElement(true)
    @XmlSerialName("link", "", "")
    val link: String,
    @XmlElement(true)
    @XmlSerialName("encoded", "http://purl.org/rss/1.0/modules/content/", "content")
    val content: String,
)
