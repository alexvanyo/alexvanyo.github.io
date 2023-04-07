import com.alexvanyo.website.buildlogic.ConventionPlugin
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.withType

class KotlinConventionPlugin : ConventionPlugin({
    with(pluginManager) {
        apply("org.jetbrains.kotlin.multiplatform")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            allWarningsAsErrors = true
            freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
})
