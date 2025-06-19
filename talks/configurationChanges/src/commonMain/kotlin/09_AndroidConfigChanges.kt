import androidx.compose.animation.animateContentSize
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
import dev.bnorm.storyboard.text.highlight.Highlighting
import dev.bnorm.storyboard.text.highlight.style
import dev.bnorm.storyboard.text.magic.MagicText
import dev.bnorm.storyboard.toState
import theme.INTELLIJ_DARK_CODE_XML_HIGHLIGHTING
import theme.jetBrainsMono

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene09_AndroidConfigChanges() {
    val xmlHighlighting = INTELLIJ_DARK_CODE_XML_HIGHLIGHTING
    scene(
        states = listOf(
            AndroidConfigChangesSceneState(
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "\"", " />\n",
                ).style(xmlHighlighting).drop(2)
            ),
            AndroidConfigChangesSceneState(
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "locale", "\"", " />\n",
                ).style(xmlHighlighting).drop(2),
            ),
            AndroidConfigChangesSceneState(
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "density", "\"", " />\n",
                ).style(xmlHighlighting).drop(2),
            ),
            AndroidConfigChangesSceneState(
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "density", "|locale", "\"", " />\n",
                ).style(xmlHighlighting).drop(2),
            ),
            AndroidConfigChangesSceneState(
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "assetsPaths|colorMode|density|fontScale\n" +
                    "        |fontWeightAdjustment|grammaticalGender|keyboard|keyboardHidden\n" +
                    "        |layoutDirection|locale|mcc|mnc|navigation|orientation|screenLayout\n" +
                    "        |screenSize|smallestScreenSize|touchscreen|uiMode",
                    "\"", " />\n",
                ).style(xmlHighlighting).drop(2),
            ),
        ),
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            val xmlCode = transition.createChildTransition { it.toState().xmlCode }
            ProvideTextStyle(TextStyle(fontFamily = jetBrainsMono)) {
                Box(
                    modifier = Modifier.animateContentSize(
                        clip = false,
                    )
                ) {
                    MagicText(
                        xmlCode,
                    )
                }
            }
        }
    }
}

private data class AndroidConfigChangesSceneState(
    val xmlCode: List<AnnotatedString>,
)

private fun List<String>.style(highlighting: Highlighting): List<AnnotatedString> {
    val merged = this.joinToString(separator = "")
    val styledMerged = merged.style(highlighting)

    val split = buildList {
        var index = 0
        for (element in this@style) {
            this.add(styledMerged.subSequence(index, index + element.length))
            index += element.length
        }
    }

    return split
}
