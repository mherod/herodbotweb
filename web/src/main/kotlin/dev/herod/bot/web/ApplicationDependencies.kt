package dev.herod.bot.web

import dev.herod.bot.web.routes.Routes
import javax.inject.Inject

class ApplicationDependencies {
    @Inject
    lateinit var routes: Routes
}
