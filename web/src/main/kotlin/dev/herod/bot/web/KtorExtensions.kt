package dev.herod.bot.web

import com.google.gson.Gson
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.parseClientCookiesHeader
import io.ktor.request.ApplicationRequest
import io.ktor.response.respondText
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.cio.toByteArray
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json
import java.nio.charset.Charset

suspend fun ApplicationRequest.postBody(): String = receiveChannel().toByteArray().toString(Charset.defaultCharset())

@KtorExperimentalAPI
val ApplicationCall.allParameters: Map<String, String>
    get() = HashMap<String, String>().apply {
        request.headers.getAll("Cookie")
            ?.map { parseClientCookiesHeader(it) }
            ?.forEach { putAll(it) }
        parameters.names().forEach { name ->
            put(name, parameters[name].orEmpty())
        }
    }

suspend inline fun <reified T : Any> ApplicationCall.respondJson(
    serializer: SerializationStrategy<T>,
    crossinline t: suspend ApplicationCall.() -> T
) {
    val obj = t.invoke(this)
    respondText(
        Json.stringify(serializer, obj).trim(),
        ContentType.Application.Json
    )
}

suspend inline fun <reified T : Any> ApplicationCall.respondJson(crossinline t: suspend ApplicationCall.() -> T) {
    val obj = t.invoke(this)
    respondText(
        Gson().toJson(obj),
        ContentType.Application.Json
    )
}

suspend inline fun ApplicationCall.respondText2(crossinline t: suspend ApplicationCall.() -> String) {
    respondText(
        t(this),
        ContentType.Text.Any
    )
}
