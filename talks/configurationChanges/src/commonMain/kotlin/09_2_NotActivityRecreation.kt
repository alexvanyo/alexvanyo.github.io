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
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene09_2_NotActivityRecreation() {
    scene(
        stateCount = 3,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        val state = transition.createChildTransition { it.toState() }

        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                "You can't opt-out of all Activity recreation",
                style = MaterialTheme.typography.h4,
            )


            Spacer(Modifier.height(32.dp))
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                state.AnimatedVisibility(
                    visible = { it >= 1 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tMemory pressure and process death",
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 2 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tLosing temporary permissions",
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
        }
    }
}
