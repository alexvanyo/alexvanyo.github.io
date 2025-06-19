import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.SceneScope
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState

@OptIn(ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene08_DefinitionsScene2() {
    scene(
        stateCount = 2,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        DefinitionsScene2Content()
    }
}

context(_: AnimatedVisibilityScope, scope: SharedTransitionScope)
@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class, ExperimentalAnimationApi::class)
@Composable
private fun SceneScope<Int>.DefinitionsScene2Content() {
    val state = transition.createChildTransition { it.toState() }

    Row(
        Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                "Configuration",
                style = MaterialTheme.typography.h4,
            )
            Text(
                "Changes",
                style = MaterialTheme.typography.h4,
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            state.AnimatedVisibility(
                visible = { it >= 1 },
                enter = fadeIn() + expandIn(expandFrom = Alignment.BottomCenter),
                exit = ExitTransition.None
            ) {
                Text(
                    "by default*",
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            Text(
                "cause",
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                "Activity",
                style = MaterialTheme.typography.h4,
            )
            Text(
                "Recreation",
                style = MaterialTheme.typography.h4,
            )
        }
    }
}
