@file:Suppress("UNUSED_PARAMETER")

package dev.herod.bot.web

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.basic
import io.ktor.features.Compression
import io.ktor.features.ContentNegotiation
import io.ktor.features.deflate
import io.ktor.features.gzip
import io.ktor.features.minimumSize
import io.ktor.gson.gson
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.routing
import io.ktor.server.netty.EngineMain
import dev.herod.bot.web.auth.checkAccessToken
import io.ktor.auth.Principal

fun main(args: Array<String>) {
    EngineMain.main(args)
}

private val dependencies = ApplicationDependencies()

@Suppress("unused")
@JvmOverloads
fun Application.module(testing: Boolean = false) {

    webComponent.inject(dependencies)

    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024)
        }
    }

    install(Authentication) {
        basic("herod") {
            realm = "Herodbot"
            skipWhen { call ->
                checkAccessToken(call.parameters["token"])
            }
            validate { (username, password) ->
                object : Principal {}
            }
        }
    }

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {

        dependencies.routes.install(this)

        static("/static") {
            resources("static")
        }
    }
}
