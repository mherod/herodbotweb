@file:Suppress("PropertyName")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val dagger_version: String by project
val logback_version: String by project
val appengine_version: String by project
val gce_logback_version: String by project

plugins {
    idea
    application
    kotlin("jvm")
    kotlin("kapt")
    id("com.github.johnrengelman.shadow")
    war
    id("com.google.cloud.tools.appengine")
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

appengine {
    deploy {
        projectId = "GCLOUD_CONFIG"
        version = "GCLOUD_CONFIG"
    }
}

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://kotlin.bintray.com/kotlinx") }
}

dependencies {
    api(project(":core"))
    api(project(":database"))
    compile("ch.qos.logback:logback-classic:$logback_version")
    compile(kotlin("stdlib-jdk8"))
    compile(ktor("server-servlet"))
    compile(ktor("server-netty"))
    compile(ktor("server-jetty"))
    compile(ktor("server-core"))
    compile(ktor("server-host-common"))
    compile(ktor("auth"))
    compile(ktor("gson"))
    compile(ktor("client-core"))
    compile(ktor("client-core-jvm"))
    compile(ktor("client-logging-jvm"))
    compile(ktor("client-auth-basic"))
    compile(ktor("client-json-jvm"))
    compile(ktor("client-gson"))
    compile(ktor("client-apache"))
    // compile(ktor("client-okhttp"))
    providedCompile("com.google.appengine:appengine:$appengine_version")
    compile("com.google.cloud:google-cloud-logging-logback:$gce_logback_version")
    testCompile(ktor("server-tests"))
    implementation(kotlinx("serialization-runtime", "0.11.0"))
    testCompile(kotlinx("serialization-runtime", "0.11.0"))
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")
    testImplementation("com.google.dagger:dagger:$dagger_version")
    kaptTest("com.google.dagger:dagger-compiler:$dagger_version")
}

sourceSets["main"].resources.srcDirs("src/main/resources")
sourceSets["test"].resources.srcDirs("src/test/resources")

tasks.withType<KotlinCompile>().all {
    listOf(
        "kotlinx.serialization.ImplicitReflectionSerializer",
        "kotlinx.serialization.UnstableDefault"
    ).forEach { marker ->
        kotlinOptions.freeCompilerArgs += "-Xexperimental=$marker"
    }
}

fun ktor(module: String, version: String = ktor_version) = "io.ktor:ktor-$module:$version"

fun kotlinx(module: String, version: String) = "org.jetbrains.kotlinx:kotlinx-$module:$version"
