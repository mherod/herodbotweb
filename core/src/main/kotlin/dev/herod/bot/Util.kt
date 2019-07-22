package dev.herod.bot

import java.io.File

fun getEnv(name: String): String {
    return runCatching { getEnv(name) }
        .recover {
            File("../.env").readLines()
                .first { it.startsWith("$name=") }
                .substringAfter('=')
        }.getOrThrow()
}
