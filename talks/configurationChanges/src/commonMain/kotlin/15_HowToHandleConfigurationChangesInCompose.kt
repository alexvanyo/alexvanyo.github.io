import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState
import theme.jetBrainsMono

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene15_HowToHandleConfigurationChangesInCompose() {
    scene(
        stateCount = 4,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        val state = transition.createChildTransition { it.toState() }

        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
        ) {
            Text(
                buildAnnotatedString {
                    append("How to handle configuration changes in Compose without recreation:")
                },
                style = MaterialTheme.typography.h4,
            )
            Spacer(Modifier.height(24.dp))
            state.AnimatedVisibility(
                visible = { it >= 1 },
                enter = expandVertically(expandFrom = Alignment.Top),
            ) {
                Text(
                    buildAnnotatedString {
                        append("All usages of configuration must be backed by snapshot state, using either")
                    },
                    style = MaterialTheme.typography.h4,
                )
            }
            state.AnimatedVisibility(
                visible = { it >= 2 },
                enter = expandVertically(expandFrom = Alignment.Top),
            ) {
                Text(
                    buildAnnotatedString {
                        append("\u2022\t")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalConfiguration.current")
                        }
                        append(", or")
                    },
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(8.dp),
                )
            }
            state.AnimatedVisibility(
                visible = { it >= 3 },
                enter = expandVertically(expandFrom = Alignment.Top),
            ) {
                Text(
                    buildAnnotatedString {
                        append("\u2022\t")
                        append("Something derived from ")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalConfiguration.current")
                        }
                    },
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
    }
}
