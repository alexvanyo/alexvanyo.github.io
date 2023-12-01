package com.alexvanyo.website.buildlogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType

fun Project.configureKotlin() {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            allWarningsAsErrors = true
            freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
            jvmTarget = jvmTargetVersion.toString()
        }
    }
}
