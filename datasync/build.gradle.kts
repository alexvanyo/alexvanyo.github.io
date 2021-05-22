plugins {
    application
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.serialization") version Versions.kotlin
}

application {
    mainClass.set("com.alexvanyo.website.datasync.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":data"))
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.cio)
    implementation(libs.xmlutil.serialization)
}

tasks {
    val classes by existing

    val runUpdateData by registering(JavaExec::class) {
        dependsOn(classes)
        main = "com.alexvanyo.website.datasync.ApplicationKt"
        classpath = sourceSets.main.get().runtimeClasspath
        args = listOf("$rootDir/website/src/jsMain/resources/data/articles.json")
    }
}
