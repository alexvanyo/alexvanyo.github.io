import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene07_ResourcesScene() {
    scene(
        stateCount = 5,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        val state = transition.createChildTransition { it.toState() }

        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                "Qualified resources are derived from configuration...",
                style = MaterialTheme.typography.h4,
            )
            state.AnimatedVisibility(
                visible = { it >= 1 },
                enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                exit = ExitTransition.None,
            ) {
                Text(
                    "So when configuration changes, qualified resources change...",
                    style = MaterialTheme.typography.h4,
                )
            }
            state.AnimatedVisibility(
                visible = { it >= 2 },
                enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                exit = ExitTransition.None,
            ) {
                Text(
                    "So we need to use the new resources...",
                    style = MaterialTheme.typography.h4,
                )
            }
            state.AnimatedVisibility(
                visible = { it >= 3 },
                enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                exit = ExitTransition.None,
            ) {
                Text(
                    "So we can throw the whole Activity away\nand recreate the entire UI",
                    style = MaterialTheme.typography.h4,
                )
            }
            state.AnimatedVisibility(
                visible = { it >= 4 },
                enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                exit = ExitTransition.None,
            ) {
                Text(
                    "But that's not the only way!",
                    style = MaterialTheme.typography.h4,
                )
            }
        }
    }
}
