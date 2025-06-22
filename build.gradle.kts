plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

tasks.register<Sync>("site") {
    into(project.layout.buildDirectory.dir("_site"))

    into("") {
        from(project(":website").tasks.named("jsBrowserDistribution"))
    }

    into("talks") {
        into("configurationchanges") {
            from(project(":talks:configurationChanges").tasks.named("wasmJsBrowserDistribution"))
        }
    }
}
