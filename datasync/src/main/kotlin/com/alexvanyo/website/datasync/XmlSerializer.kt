package com.alexvanyo.website.datasync

import io.ktor.client.features.json.JsonSerializer
import io.ktor.http.ContentType
import io.ktor.http.content.OutgoingContent
import io.ktor.http.content.TextContent
import io.ktor.util.reflect.TypeInfo
import io.ktor.utils.io.core.Input
import io.ktor.utils.io.core.readText
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer
import nl.adaptivity.xmlutil.serialization.XML

/**
 * Based on https://github.com/pdvrieze/xmlutil/issues/40
 */
class XMLSerializer(private val format: XML) : JsonSerializer {
    @OptIn(InternalSerializationApi::class, ExperimentalSerializationApi::class)
    override fun read(type: TypeInfo, body: Input): Any {
        val text = body.readText()
        val deserializationStrategy = format.serializersModule.getContextual(type.type)

        val mapper = deserializationStrategy
            ?: type.kotlinType?.let { serializer(it) }
            ?: type.type.serializer()

        return format.decodeFromString(mapper, text) ?: error("Failed to parse response of type $type. The result is null.")
    }

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    override fun write(data: Any, contentType: ContentType): OutgoingContent {
        val serializer = data::class.serializer() as KSerializer<Any>
        val payload = data
        val text = format.encodeToString(serializer, payload)
        return TextContent(text, contentType)
    }
}
