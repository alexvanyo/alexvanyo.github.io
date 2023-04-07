plugins {
    id("com.alexvanyo.website.kotlin")
    alias(libs.plugins.jetbrains.compose)
    id("com.alexvanyo.website.detekt")
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.data)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
            }
        }
    }
}
