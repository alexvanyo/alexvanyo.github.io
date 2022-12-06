plugins {
    `kotlin-dsl`
}

group = "com.alexvanyo.website.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
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
    }
}
