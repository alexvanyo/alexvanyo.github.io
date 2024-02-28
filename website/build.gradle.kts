plugins {
    id("com.alexvanyo.website.kotlin")
    alias(libs.plugins.jetbrains.compose)
    id("com.alexvanyo.website.detekt")
}

compose {
    kotlinCompilerPlugin.set(libs.versions.jetbrainsComposeCompiler.get())
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
                implementation(libs.kotlinx.coroutines.core)
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
