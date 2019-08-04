package dev.herod.bot

import java.io.File
import java.nio.file.Files
import kotlin.streams.asSequence

object EnvPropertyFinder {

    private fun findFile(fileName: String, searchFile: File = File(".")): File? {

        return Files.walk(searchFile.toPath())
            ?.asSequence()
            ?.filter { Files.isRegularFile(it) }
            ?.map { it.toFile() }
            ?.firstOrNull { it.name == fileName }
    }

    fun getEnv(name: String): String {
        return runCatching { System.getenv(name) }
            .getOrElse { getEnvFromFile(name) }
    }

    private fun getEnvFromFile(name: String): String {
        return runCatching {
            val propertiesFile = findFile(
                fileName = "env.properties",
                searchFile = File("../")
            ) ?: findFile(
                fileName = ".env",
                searchFile = File("../")
            )
            propertiesFile!!
                .readLines()
                .first { it.startsWith("$name=") }
                .substringAfter('=')
        }.onFailure { throwable ->
            println("Current directory: ${File(".").absolutePath}")
            throwable.printStackTrace()
        }.getOrThrow()
    }
}
