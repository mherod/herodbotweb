package dev.herod.bot.web

import dagger.Component
import dev.herod.bot.CoreModule

// Don't forget to update TestWebComponent too
@Component(modules = [WebModule::class, CoreModule::class])
interface WebComponent {
    fun inject(it: ApplicationDependencies)
}
