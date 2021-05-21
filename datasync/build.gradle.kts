plugins {
    application
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.32"
}

application {
    mainClass.set("com.alexvanyo.website.datasync.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":data"))
    implementation("io.ktor:ktor-client-core:1.5.2")
    implementation("io.ktor:ktor-client-serialization:1.5.2")
    implementation("io.ktor:ktor-client-cio:1.5.2")
    implementation("io.github.pdvrieze.xmlutil:serialization:0.82.0")
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

