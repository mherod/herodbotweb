package dev.herod.bot.web

import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.features.json.serializer.KotlinxSerializer

@Module
class WebModule {

    @Provides
    fun provideJsonSerializer(): JsonSerializer = KotlinxSerializer()

    @Provides
    fun provideHttpClient(jsonSerializer: JsonSerializer): HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = jsonSerializer
        }
    }
}
