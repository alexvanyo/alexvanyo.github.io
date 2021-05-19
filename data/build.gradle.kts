plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.32"
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
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
            }
        }
    }
}
