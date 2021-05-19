pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "alexvanyo-website"

include(
    ":data",
    ":website",
    ":datasync"
)
