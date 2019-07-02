package dev.herod.bot.web

import dagger.Module
import io.ktor.application.ApplicationCall

@Module
class CallModule(val call: ApplicationCall)
