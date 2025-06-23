import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ProvideTextStyle
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import components.animateContentSize
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.text.highlight.CodeStyle
import dev.bnorm.storyboard.text.highlight.Language
import dev.bnorm.storyboard.text.highlight.highlight
import dev.bnorm.storyboard.text.magic.MagicText
import dev.bnorm.storyboard.toState
import theme.INTELLIJ_DARK_CODE_STYLE
import theme.jetBrainsMono

@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene22_Example6_TestingScene() {
    val kotlinHighlighting = INTELLIJ_DARK_CODE_STYLE
    scene(
        states = listOf(
            listOf(
                "runComposeUiTest {\n",
                "    var locales by mutableStateOf(LocaleList(\"en-US\"))\n",
                "    setContent {\n",
                "        DeviceConfigurationOverride(\n",
                "            DeviceConfigurationOverride.Locales(locales),\n",
                "        ) {\n",
                "            MyApp()\n",
                "        }\n",
                "    }\n",
                "    // check for English\n",
                "}"
            ).highlight(kotlinHighlighting),
            listOf(
                "runComposeUiTest {\n",
                "    var locales by mutableStateOf(LocaleList(\"en-US\"))\n",
                "    setContent {\n",
                "        DeviceConfigurationOverride(\n",
                "            DeviceConfigurationOverride.Locales(locales),\n",
                "        ) {\n",
                "            MyApp()\n",
                "        }\n",
                "    }\n",
                "    // check for English\n",
                "    locales = LocaleList(\"es-US\")\n",
                "    // check for Spanish\n",
                "}"
            ).highlight(kotlinHighlighting),
        ),
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(64.dp),
        ) {
            val kotlinCodeTransition = transition.createChildTransition { it.toState() }
            ProvideTextStyle(TextStyle(fontFamily = jetBrainsMono)) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .animateContentSize(
                            clip = false,
                        )
                ) {
                    MagicText(
                        kotlinCodeTransition,
                    )
                }
            }
        }
    }
}

private fun List<String>.highlight(
    codeStyle: CodeStyle,
): List<AnnotatedString> {
    val merged = joinToString("")
    val highlighted = merged.highlight(
        codeStyle = codeStyle,
        language = Language.Kotlin,
    )

    val split = buildList {
        var index = 0
        for (element in this@highlight) {
            this.add(highlighted.subSequence(index, index + element.length))
            index += element.length
        }
    }

    return split
}
