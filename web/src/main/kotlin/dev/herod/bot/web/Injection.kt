package dev.herod.bot.web

private val webModule: WebModule by lazy(::WebModule)

val webComponent: WebComponent by lazy {
    DaggerWebComponent.builder()
        .webModule(webModule)
        .build()
}
