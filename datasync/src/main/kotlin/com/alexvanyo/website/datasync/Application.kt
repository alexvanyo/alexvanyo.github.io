package com.alexvanyo.website.datasync

import com.alexvanyo.website.data.websiteJson
import com.alexvanyo.website.datasync.models.RssFeed
import com.alexvanyo.website.models.Article
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.http.ContentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import nl.adaptivity.xmlutil.serialization.DefaultXmlSerializationPolicy
import nl.adaptivity.xmlutil.serialization.XML
import java.io.File

suspend fun main(args: Array<String>) {
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = XMLSerializer(
                XML {
                    policy = DefaultXmlSerializationPolicy(
                        pedantic = false,
                        autoPolymorphic = true,
                        unknownChildHandler = { _, _, _, _ -> },
                    )
                }
            )
            accept(ContentType.Application.Xml, ContentType.Text.Xml)
        }
    }

    val rssFeed = client.get<RssFeed>("https://medium.com/feed/@alexvanyo")

    val imageUrlRegex = Regex("""<img.*src="(.*)".*/>""")

    val articleList = rssFeed.channel.items.map { rssItem ->
        Article(
            title = rssItem.title,
            url = rssItem.link,
            imageUrl = imageUrlRegex.find(rssItem.content)!!.groupValues[1]
        )
    }

    val serializedArticles = websiteJson.encodeToString(ListSerializer(Article.serializer()), articleList)

    if (args.isEmpty()) {
        println(serializedArticles)
    } else {
        val outputDir = args[0]
        withContext(Dispatchers.IO) {
            File(outputDir).writeText(serializedArticles)
        }
    }
}
