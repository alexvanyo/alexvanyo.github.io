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

@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene09_AndroidConfigChangesScene() {
    val xmlHighlighting = INTELLIJ_DARK_CODE_XML_HIGHLIGHTING
    scene(
        states = listOf(
            AndroidConfigChangesSceneState(
                header = null,
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = null,
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "locale", "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = null,
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "density", "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = null,
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "density", "|locale", "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = null,
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "assetsPaths|colorMode|density|fontScale\n" +
                    "        |fontWeightAdjustment|grammaticalGender|keyboard|keyboardHidden\n" +
                    "        |layoutDirection|locale|mcc|mnc|navigation|orientation|screenLayout\n" +
                    "        |screenSize|smallestScreenSize|touchscreen|uiMode",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 16",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "assetsPaths|colorMode|density|fontScale\n" +
                            "        |fontWeightAdjustment|grammaticalGender|keyboard|keyboardHidden\n" +
                            "        |layoutDirection|locale|mcc|mnc|navigation|orientation|screenLayout\n" +
                            "        |screenSize|smallestScreenSize|touchscreen|uiMode",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 16",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "allKnown",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 16",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "allKnown",
                    "\"", " />\n",
                    "\n<!-- With ", "Android 16", ", aapt2 compiles to... -->\n\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "assetsPaths|colorMode|density|fontScale\n" +
                            "        |fontWeightAdjustment|grammaticalGender|keyboard|keyboardHidden\n" +
                            "        |layoutDirection|locale|mcc|mnc|navigation|orientation|screenLayout\n" +
                            "        |screenSize|smallestScreenSize|touchscreen|uiMode",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 42?",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "allKnown",
                    "\"", " />\n",
                    "\n<!-- With ", "Android 16", ", aapt2 compiles to... -->\n\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "assetsPaths|colorMode|density|fontScale\n" +
                            "        |fontWeightAdjustment|grammaticalGender|keyboard|keyboardHidden\n" +
                            "        |layoutDirection|locale|mcc|mnc|navigation|orientation|screenLayout\n" +
                            "        |screenSize|smallestScreenSize|touchscreen|uiMode",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 42?",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "allKnown",
                    "\"", " />\n",
                    "\n<!-- With ", "Android 42", ", aapt2 compiles to... -->\n\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "assetsPaths|colorMode|density|fontScale\n" +
                            "        |fontWeightAdjustment|grammaticalGender|keyboard|keyboardHidden\n" +
                            "        |layoutDirection|locale|mcc|mnc|navigation|orientation|screenLayout\n" +
                            "        |screenSize|smallestScreenSize|touchscreen|uiMode", "\n",
                            "        |lifeTheUniverseAndEverything",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 16",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "resourcesUnused",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 16",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "allKnown|resourcesUnused",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 16",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "allKnown|resourcesUnused",
                    "\"", " />\n",
                    "\n<!-- Doesn't work, aapt2 complains -->\n\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            ),
            AndroidConfigChangesSceneState(
                header = "Android 16",
                xmlCode = listOf(
                    """<?xml version="1.0" encoding="utf-8"?><application>""", "\n",
                    "<activity\n",
                    "    android:configChanges=", "\"", "assetsPaths|colorMode|density|fontScale\n" +
                    "        |fontWeightAdjustment|grammaticalGender|keyboard|keyboardHidden\n" +
                    "        |layoutDirection|locale|mcc|mnc|navigation|orientation|screenLayout\n" +
                    "        |screenSize|smallestScreenSize|touchscreen|uiMode", "\n",
                    "        |resourcesUnused",
                    "\"", " />\n",
                    "</application>\n",
                ).style(xmlHighlighting).drop(2).dropLast(1),
            )
        ),
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            val headerTransition = transition.createChildTransition { it.toState().header }
            headerTransition.AnimatedContent(
                modifier = Modifier.fillMaxWidth(),
                transitionSpec = {
                    fadeIn(animationSpec = tween(220, delayMillis = 90)) togetherWith
                            fadeOut(tween(90))
                }
            ) { targetHeader ->
                if (targetHeader == null) {
                    Spacer(Modifier.fillMaxWidth())
                } else {
                    Text(
                        targetHeader,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
                    )
                }
            }

            val xmlCodeTransition = transition.createChildTransition { it.toState().xmlCode }
            ProvideTextStyle(TextStyle(fontFamily = jetBrainsMono)) {
                Box(
                    modifier = Modifier.animateContentSize(
                        clip = false,
                    )
                ) {
                    MagicText(
                        xmlCodeTransition,
                    )
                }
            }
        }
    }
}

private data class AndroidConfigChangesSceneState(
    val header: String?,
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
