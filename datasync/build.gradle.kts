import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.detekt)
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        allWarningsAsErrors = true
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}

application {
    mainClass.set("com.alexvanyo.website.datasync.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(projects.data)
    implementation(libs.ktor.client.content.negotation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.serialization.xml)
}

tasks {
    val run by existing(JavaExec::class)
    val classes by existing

    val runUpdateData by registering(JavaExec::class) {
        dependsOn(classes)
        mainClass.set(run.get().mainClass.get())
        classpath = run.get().classpath
        args = listOf("$rootDir/website/src/jsMain/resources/data")
    }
}

detekt {
    source = files("src/main/kotlin")
}
