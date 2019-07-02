package dev.herod.bot.web.auth

import io.ktor.client.HttpClient
import javax.inject.Inject
import javax.inject.Named

class GithubCall {
    @Named("GithubHttpClient")
    @Inject
    lateinit var httpClient: HttpClient
}
