import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun StoryboardBuilder.Scene19_Example3_DateFormatting() {
    val kotlinHighlighting = INTELLIJ_DARK_CODE_STYLE
    scene(
        states = listOf(
            listOf(
                "@Composable\n",
                "fun DateText(\n",
                "    localDate: java.time.LocalDate,\n",
                "    pattern: String = \"MMM dd\",\n",
                ") {\n",
                "    val dateTimeFormatter = remember(", "pattern) {\n",
                "        DateTimeFormatter.ofPattern(", "pattern", ")\n",
                "    }\n",
                "    Text(dateTimeFormatter.format(localDate))\n",
                "}"
            ).highlight(kotlinHighlighting),
            listOf(
                "@Composable\n",
                "fun DateText(\n",
                "    localDate: java.time.LocalDate,\n",
                "    pattern: String = \"MMM dd\",\n",
                ") {\n",
                "    val configuration = LocalConfiguration.current\n",
                "    val dateTimeFormatter = remember(", "pattern) {\n",
                "        DateTimeFormatter.ofPattern(", "\n",
                "            ", "pattern", ",\n",
                "            ConfigurationCompat.getLocales(configuration).get(0)\n",
                "        ", ")\n",
                "    }\n",
                "    Text(dateTimeFormatter.format(localDate))\n",
                "}"
            ).highlight(kotlinHighlighting),
            listOf(
                "@Composable\n",
                "fun DateText(\n",
                "    localDate: java.time.LocalDate,\n",
                "    pattern: String = \"MMM dd\",\n",
                ") {\n",
                "    val configuration = LocalConfiguration.current\n",
                "    val dateTimeFormatter = remember(", "configuration, ", "pattern) {\n",
                "        DateTimeFormatter.ofPattern(", "\n",
                "            ", "pattern", ",\n",
                "            ConfigurationCompat.getLocales(configuration).get(0)\n",
                "        ", ")\n",
                "    }\n",
                "    Text(dateTimeFormatter.format(localDate))\n",
                "}"
            ).highlight(kotlinHighlighting),
        ),
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(64.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            val kotlinCodeTransition = transition.createChildTransition { it.toState() }
            ProvideTextStyle(TextStyle(fontFamily = jetBrainsMono)) {
                Box(
                    modifier = Modifier.animateContentSize(
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

