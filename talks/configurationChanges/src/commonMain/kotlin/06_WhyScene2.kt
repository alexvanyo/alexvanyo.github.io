import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene06_WhyScene2() {
    scene(
        stateCount = 2,
        enterTransition = SceneEnter(Alignment.CenterStart),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        val state = transition.createChildTransition { it.toState() }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Why?",
                style = MaterialTheme.typography.h2,
            )

            state.AnimatedVisibility(
                visible = { it >= 1 },
                enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                exit = ExitTransition.None,
            ) {
                Text(
                    "Resources",
                    style = MaterialTheme.typography.h2,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(top = 64.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}
