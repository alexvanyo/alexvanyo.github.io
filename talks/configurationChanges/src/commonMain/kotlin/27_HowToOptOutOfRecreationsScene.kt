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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene27_HowToOptOutOfRecreationsScene() {
    scene(
        6,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        val state = transition.createChildTransition { it.toState() }

        Column(
            modifier = Modifier.padding(32.dp).fillMaxSize(),
        ) {
            Text(
                text = AnnotatedString("How to opt-out of recreation"),
                style = MaterialTheme.typography.h3,
            )

            Spacer(Modifier.height(32.dp))
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

                state.AnimatedVisibility(
                    visible = { it >= 1 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tOne configuration change type at a time, in one Activity at a time",
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 2 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tTry opting out of recreation, validating behavior",
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 3 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tFix anything that doesn't recompose correctly",
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 4 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tStart validating all new changes also recompose correctly",
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 5 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tStart with the least risky, and highest benefit",
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
        }
    }
}
