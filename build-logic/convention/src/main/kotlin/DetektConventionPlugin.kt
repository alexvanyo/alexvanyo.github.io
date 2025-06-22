import com.alexvanyo.website.buildlogic.ConventionPlugin
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

class DetektConventionPlugin : ConventionPlugin({
    with(pluginManager) {
        apply("io.gitlab.arturbosch.detekt")
    }

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    extensions.configure<DetektExtension> {
        buildUponDefaultConfig = true
        allRules = true
        autoCorrect = System.getenv("CI") != "true"
        config.setFrom("$rootDir/config/detekt.yml")
        source.setFrom(
            files(
                "src/commonMain/kotlin",
                "src/jsMain/kotlin",
                "src/jvmMain/kotlin",
                "src/wasmJsMain/kotlin",
            )
        )
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }

    dependencies {
        add("detektPlugins", libs.findLibrary("detekt.formatting").get())
    }
})
