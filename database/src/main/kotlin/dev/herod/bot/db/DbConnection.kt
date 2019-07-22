package dev.herod.bot.db

import dev.herod.bot.getEnv
import java.net.URI
import java.net.URISyntaxException
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DbConnection {

    @Throws(URISyntaxException::class, SQLException::class)
    fun getMyDbConnection(): Connection {
        val dbUri = URI(getEnv("DATABASE_URL"))
        val userInfo = dbUri.userInfo
        val username = userInfo.substringBefore(':')
        val password = userInfo.substringAfter(':')
        val dbUrl = "jdbc:postgresql://${dbUri.host}:${dbUri.port}${dbUri.path}?sslmode=require"
        return DriverManager.getConnection(dbUrl, username, password)
    }
}
