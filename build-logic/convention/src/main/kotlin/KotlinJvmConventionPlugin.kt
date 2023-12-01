import com.alexvanyo.website.buildlogic.ConventionPlugin
import com.alexvanyo.website.buildlogic.configureKotlin
import com.alexvanyo.website.buildlogic.jvmTargetVersion
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinJvmConventionPlugin : ConventionPlugin({
    with(pluginManager) {
        apply("org.jetbrains.kotlin.multiplatform")
    }

    configureKotlin()

    extensions.configure<KotlinMultiplatformExtension> {
        jvm()
    }

    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = jvmTargetVersion
        targetCompatibility = jvmTargetVersion
    }
})
