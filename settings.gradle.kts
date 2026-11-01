enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "alexvanyo-website"

includeBuild("storyboard")

include(
    ":data",
    ":website",
    ":datasync",
    ":talks:configurationChanges",
)
