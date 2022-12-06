import com.alexvanyo.website.buildlogic.ConventionPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

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
        source = files(
            "src/commonMain/kotlin",
            "src/jsMain/kotlin",
        )
    }

    dependencies {
        add("detektPlugins", libs.findLibrary("detekt.formatting").get())
    }
})
