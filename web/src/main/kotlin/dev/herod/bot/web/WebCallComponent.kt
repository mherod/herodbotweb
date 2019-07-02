package dev.herod.bot.web

import dagger.Component

@Component(
        dependencies = [WebComponent::class],
        modules = [CallModule::class]
)
interface WebCallComponent
