package dev.herod.bot.web

import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.JsonSerializer
import javax.inject.Named

@Module
class WebModule {

    @Provides
    fun provideJsonSerializer(): JsonSerializer = GsonSerializer()

    @Named("ServerHttpClient")
    @Provides
    fun provideHttpClient(jsonSerializer: JsonSerializer): HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = jsonSerializer
        }
    }
}
