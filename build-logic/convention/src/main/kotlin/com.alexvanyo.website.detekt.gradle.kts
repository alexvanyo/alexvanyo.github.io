plugins {
    id("io.gitlab.arturbosch.detekt")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

detekt {
    buildUponDefaultConfig = true
    allRules = true
    autoCorrect = System.getenv("CI") != "true"
    config.setFrom("$rootDir/config/detekt.yml")
    source = files(
        "src/commonMain/kotlin",
        "src/jsMain/kotlin",
    )
}

dependencies {
    detektPlugins(libs.findLibrary("detekt.formatting").get())
}
