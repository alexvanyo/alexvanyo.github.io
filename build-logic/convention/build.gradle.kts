import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.alexvanyo.website.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
        allWarningsAsErrors = true
    }
}

dependencies {
    implementation(kotlin("gradle-plugin", libs.versions.kotlin.get()))
    implementation(libs.detekt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("detekt") {
            id = "com.alexvanyo.website.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("kotlin") {
            id = "com.alexvanyo.website.kotlin"
            implementationClass = "KotlinConventionPlugin"
        }
        register("kotlinJvm") {
            id = "com.alexvanyo.website.kotlinJvm"
            implementationClass = "KotlinJvmConventionPlugin"
        }
    }
}
