package com.alexvanyo.website.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project

open class ConventionPlugin(
    val configure: Project.() -> Unit = {},
) : Plugin<Project> {
    final override fun apply(target: Project) {
        configure(target)
    }
}
