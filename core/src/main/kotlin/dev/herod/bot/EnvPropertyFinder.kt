package dev.herod.bot

import java.io.File

object EnvPropertyFinder {

    private fun findFile(fileName: String, searchFile: File = File(".")): File? {
        return when {
            searchFile.isFile && searchFile.name == fileName -> searchFile
            else -> searchFile.listFiles()?.mapNotNull { findFile(fileName, it) }?.firstOrNull()
        }
    }

    fun getEnv(name: String): String {
        return runCatching { getEnv(name) }
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
        }.onFailure {
            println("Current directory: ${File(".").absolutePath}")
        }.getOrThrow()
    }
}
