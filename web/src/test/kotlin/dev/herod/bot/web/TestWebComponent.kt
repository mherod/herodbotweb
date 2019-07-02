package dev.herod.bot.web

import dagger.Component
import dev.herod.bot.CoreModule
import dev.herod.bot.foursquare.FoursquareClientTest

@Component(modules = [WebModule::class, CoreModule::class])
interface TestWebComponent {
    fun inject(it: FoursquareClientTest)
}
