package dev.herod.bot

import java.io.File

fun getEnv(name: String): String {
    return runCatching { getEnv(name) }
        .getOrElse { getEnvFromFile(name) }
}

private fun getEnvFromFile(name: String): String {
    return runCatching {
        File("../.env").readLines()
            .first { it.startsWith("$name=") }
            .substringAfter('=')
    }.getOrThrow()
}
