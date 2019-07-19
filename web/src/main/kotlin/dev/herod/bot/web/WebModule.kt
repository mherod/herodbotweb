package dev.herod.bot.web

import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

@Module
class WebModule {

    @Provides
    fun provideJsonSerializer(): JsonSerializer = KotlinxSerializer(json = Json.nonstrict)

    @Provides
    fun provideHttpClient(jsonSerializer: JsonSerializer): HttpClient = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = jsonSerializer
        }
    }
}
