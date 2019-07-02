import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val dagger_version: String by project

plugins {
    kotlin("jvm")
    kotlin("kapt")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":models"))
    api("net.rcarz:jira-client:0.5")
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")
    testImplementation("junit:junit:4.12")
    testImplementation("com.nhaarman:mockito-kotlin:1.6.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
