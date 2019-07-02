import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("kotlinx-serialization")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("joda-time:joda-time:2.10.2")
    implementation(kotlinx("serialization-runtime", "0.11.0"))
    testCompile(kotlinx("serialization-runtime", "0.11.0"))
    testImplementation("junit:junit:4.12")
}

tasks.withType<KotlinCompile>().all {
    listOf(
        "kotlinx.serialization.ImplicitReflectionSerializer",
        "kotlinx.serialization.UnstableDefault"
    ).forEach { marker ->
        kotlinOptions.freeCompilerArgs += "-Xexperimental=$marker"
    }
    kotlinOptions.jvmTarget = "1.8"
}

fun kotlinx(module: String, version: String) = "org.jetbrains.kotlinx:kotlinx-$module:$version"
