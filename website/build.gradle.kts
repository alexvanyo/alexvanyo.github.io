plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Versions.composeWeb
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
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
                implementation("com.arkivanov.decompose:decompose:0.2.4")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(compose.web.web)
                implementation(compose.runtime)
            }
        }
    }
}
