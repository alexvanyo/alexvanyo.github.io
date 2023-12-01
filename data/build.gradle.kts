plugins {
    id("com.alexvanyo.website.kotlinJvm")
    alias(libs.plugins.kotlinx.serialization)
    id("com.alexvanyo.website.detekt")
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
