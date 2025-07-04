plugins {
    id("com.alexvanyo.website.kotlinJvm")
    alias(libs.plugins.kotlinx.serialization)
    id("com.alexvanyo.website.detekt")
}

kotlin {
    jvm {
        compilations {
            val main = getByName("main")
            val runUpdateData by tasks.registering(JavaExec::class) {
                mainClass.set("com.alexvanyo.website.datasync.ApplicationKt")
                classpath = main.output.classesDirs
                classpath += main.compileDependencyFiles
                args = listOf("$rootDir/website/src/jsMain/resources/data")
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.data)
                implementation(libs.ktor.client.content.negotation)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.serialization.xml)
            }
        }
    }
}
