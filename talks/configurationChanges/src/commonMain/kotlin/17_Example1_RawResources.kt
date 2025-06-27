import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import dev.bnorm.storyboard.text.highlight.Highlighting
import dev.bnorm.storyboard.text.highlight.Language
import dev.bnorm.storyboard.text.highlight.highlight
import dev.bnorm.storyboard.text.highlight.style
import dev.bnorm.storyboard.text.magic.MagicText
import dev.bnorm.storyboard.toState
import theme.INTELLIJ_DARK_CODE_STYLE
import theme.INTELLIJ_DARK_CODE_XML_HIGHLIGHTING
import theme.INTELLIJ_LIGHT_CODE_STYLE
import theme.LocalCodeStyle
import theme.jetBrainsMono

@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene17_Example1_RawResources(
    kotlinHighlighting: CodeStyle,
) {
    scene(
        states = listOf(
            listOf(
                "@Composable\n",
                "fun getMyString(): String {\n",
                "    return ", "LocalContext.current.resources", ".getString", "(R.string.theBestString)\n",
                "}"
            ).highlight(kotlinHighlighting),
            listOf(
                "@Composable\n",
                "fun getMyString(): String {\n",
                "    return ", "LocalResources.current", ".getString", "(R.string.theBestString)\n",
                "}"
            ).highlight(kotlinHighlighting),
            listOf(
                "@Composable\n",
                "fun getMyString(): String {\n",
                "    return ", "stringResource", "(R.string.theBestString)\n",
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

