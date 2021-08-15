plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization") version Versions.kotlin
    id("io.gitlab.arturbosch.detekt") version Versions.detekt
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        allWarningsAsErrors = true
    }
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.serialization.json)
            }
        }
    }
}

detekt {
    source = files("src/commonMain/kotlin")
}
