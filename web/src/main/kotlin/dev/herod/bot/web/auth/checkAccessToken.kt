package dev.herod.bot.web.auth

import dev.herod.bot.db.DbConnection.getMyDbConnection
import java.sql.ResultSet

fun checkAccessToken(inputToken: String?): Boolean {
    inputToken ?: return false

    val output: MutableList<String> = mutableListOf()
    val out: ResultSet = getMyDbConnection()
        .prepareStatement("SELECT token FROM access where token = ?")
        .apply { setString(1, inputToken) }
        .executeQuery()

    while (out.next()) {
        runCatching {
            output += out.getString("token")
        }.onFailure {
            out.close()
        }
    }
    return output.size == 1
}
