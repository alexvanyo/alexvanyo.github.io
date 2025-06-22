package com.alexvanyo.website.datasync

import com.alexvanyo.website.data.websiteJson
import com.alexvanyo.website.datasync.models.RssFeed
import com.alexvanyo.website.models.Article
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.xml.xml
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.builtins.ListSerializer
import nl.adaptivity.xmlutil.ExperimentalXmlUtilApi
import nl.adaptivity.xmlutil.serialization.DefaultXmlSerializationPolicy
import nl.adaptivity.xmlutil.serialization.UnknownChildHandler
import nl.adaptivity.xmlutil.serialization.XML
import java.io.File

suspend fun main(args: Array<String>) {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            xml(
                format = XML {
                    @OptIn(ExperimentalXmlUtilApi::class)
                    policy = DefaultXmlSerializationPolicy.Builder().apply {
                        pedantic = false
                        autoPolymorphic = true
                        unknownChildHandler = UnknownChildHandler { _, _, _, _, _ -> emptyList() }
                    }.build()
                },
                contentType = ContentType.Text.Xml
            )
        }
    }

    val rssFeed: RssFeed = client.get("https://medium.com/feed/@alexvanyo").body()

    /**
     * Regex to pull out the url for images within the article content.
     */
    val imageUrlRegex = Regex("""<img.*?src="(.*?)".*?>""")

    val articleList = rssFeed.channel.items.map { rssItem ->
        val availableContent = rssItem.content ?: rssItem.description ?: ""
        Article(
            title = rssItem.title,
            url = rssItem.link,
            // Find the url for the first image in the article
            imageUrl = imageUrlRegex.find(availableContent)!!.groupValues[1]
        )
    }

    val serializedArticles = websiteJson.encodeToString(ListSerializer(Article.serializer()), articleList)

    if (args.isEmpty()) {
        println(serializedArticles)
    } else {
        val outputDir = args[0]
        val outputDirFile = File(outputDir)

        withContext(Dispatchers.IO) {
            outputDirFile.mkdirs()
            File(outputDirFile, "articles.json").apply {
                createNewFile()
                writeText(serializedArticles)
            }
        }
    }
}
