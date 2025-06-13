import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.jetbrains.compose)
}

group = "alex.vanyo.dev.talks.configurationchanges"
version = "0.1-SNAPSHOT"

kotlin {
    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        binaries.executable()
        browser()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.storyboard.core)
                implementation(libs.storyboard.easel)
                implementation(libs.storyboard.text)
                implementation(libs.jetbrains.compose.material)
                implementation(compose.components.resources)
            }
        }
        jvmMain {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

extensions.configure<KotlinMultiplatformExtension> {
    sourceSets.all {
        languageSettings {
            enableLanguageFeature("ContextParameters")
        }
    }
}

compose {
    resources.publicResClass = true
    desktop.application.mainClass = "Main_desktopkt"
}
