import com.alexvanyo.website.buildlogic.ConventionPlugin
import com.alexvanyo.website.buildlogic.configureKotlin

class KotlinConventionPlugin : ConventionPlugin({
    with(pluginManager) {
        apply("org.jetbrains.kotlin.multiplatform")
    }

    configureKotlin()
})
