import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene13_ItsComposeScene() {
    scene(
        4,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterStart),
    ) {
        val state = transition.createChildTransition { it.toState() }

        Column(
            modifier = Modifier.padding(32.dp).fillMaxSize(),
        ) {
            state.AnimatedContent(
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                }
            ) {
                if (it < 3) {
                    Text(
                        text = "",
                        style = MaterialTheme.typography.h3,
                    )
                } else {
                    Text(
                        text = AnnotatedString("Compose!"),
                        style = MaterialTheme.typography.h3,
                    )
                }
            }

            Spacer(Modifier.height(32.dp))
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    "\u2022\tCreate an observable source of truth",
                    style = MaterialTheme.typography.h5,
                )
                state.AnimatedVisibility(
                    visible = { it >= 1 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tAutomatically subscribe to changes",
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 2 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tPropagate changes to perform any needed updates",
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
        }
    }
}
