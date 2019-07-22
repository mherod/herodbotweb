package dev.herod.bot.web.routes

import dev.herod.bot.db.DbConnection
import dev.herod.bot.getEnv
import dev.herod.bot.web.framework.RoutesInstaller
import dev.herod.bot.web.postBody
import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.call
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.default
import io.ktor.http.content.files
import io.ktor.http.content.static
import io.ktor.request.httpMethod
import io.ktor.request.uri
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import java.io.File
import java.sql.PreparedStatement
import javax.inject.Inject

class Routes @Inject constructor(
    private val webRoutesInstaller: WebRoutesInstaller,
    private val foursquareRoutesInstaller: FoursquareRoutesInstaller,
    private val spotifyRoutesInstaller: SpotifyRoutesInstaller
) : RoutesInstaller {

    override fun install(route: Route) {
        route.post {
            call.respond(HttpStatusCode.OK)
        }

        route.apply {
            intercept(ApplicationCallPipeline.Monitoring) {
                val request = call.request
                if (request.httpMethod == HttpMethod.Post) {
                    DbConnection.getMyDbConnection().use { connection ->
                        connection.prepareStatement(
                            "INSERT INTO \"postings\" (\"id\", \"blob\", \"url\") VALUES (DEFAULT, ?, ?)"
                        )?.use { preparedStatement: PreparedStatement ->
                            preparedStatement.setString(1, request.uri)
                            preparedStatement.setString(2, request.postBody())
                            preparedStatement.execute()
                        }
                    }
                }
            }
        }

        route.route("/") {
            static {
                files("static")
                default("static/index.html")
            }
            get("/hi") {
                call.respondText {
                    "Herodbot [ ${call.parameters} ] [${File(".").absolutePath}]"
                }
            }
            webRoutesInstaller.install(this)
        }
        route.route("/api") {
            route("/4sq") {
                foursquareRoutesInstaller.install(this)
            }
            route("/spotify") {
                spotifyRoutesInstaller.install(this)
            }
        }
        route.get("dump") {
            println(getEnv("DATABASE_URL"))
            call.respondRedirect {
                port = 443
                path("")
            }
        }
    }
}
