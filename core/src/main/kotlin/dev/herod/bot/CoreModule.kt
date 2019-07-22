package dev.herod.bot

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CoreModule {
    @Provides
    @Named("ENV_HOME")
    fun provideEnvironmentHomePath(): String = getEnv("HOME")
}
