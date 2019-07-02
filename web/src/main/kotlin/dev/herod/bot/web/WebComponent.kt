package dev.herod.bot.web

import dagger.Component
import dev.herod.bot.CoreModule

@Component(modules = [WebModule::class, CoreModule::class])
interface WebComponent {
    fun inject(it: ApplicationDependencies)
}
