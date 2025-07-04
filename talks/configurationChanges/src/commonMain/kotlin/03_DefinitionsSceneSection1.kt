import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import theme.jetBrainsMono

@OptIn(ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene03_DefinitionsScene1() {
    scene(
        stateCount = 7,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        DefinitionsScene1Content()
    }
}

context(_: AnimatedVisibilityScope, scope: SharedTransitionScope)
@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class, ExperimentalAnimationApi::class)
@Composable
private fun SceneScope<Int>.DefinitionsScene1Content() {
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
            state.AnimatedVisibility(
                visible = { it >= 1 },
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    state.AnimatedVisibility(
                        visible = { it == 1 || it >= 3 },
                        enter = fadeIn(),
                        exit = fadeOut(),
                    ) {
                        Text(
                            "Configuration",
                            style = MaterialTheme.typography.h4
                        )
                    }
                    state.AnimatedVisibility(
                        visible = { it == 2 },
                        enter = fadeIn(),
                        exit = fadeOut(),
                    ) {
                        Text(
                            "Configuration.java",
                            style = MaterialTheme.typography.h4,
                            fontFamily = jetBrainsMono,
                        )
                    }
                }
            }
            state.AnimatedVisibility(
                visible = { it >= 3 },
                enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                exit = ExitTransition.None,
            ) {
                Text(
                    "Changes",
                    style = MaterialTheme.typography.h4,
                )
            }
        }

        state.AnimatedVisibility(
            visible = { it >= 5 },
            enter = fadeIn() + expandHorizontally(expandFrom = Alignment.CenterHorizontally),
            exit = fadeOut(),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(16.dp),
            ) {
                state.AnimatedVisibility(
                    visible = { it == 5 },
                    enter = EnterTransition.None,
                    exit = fadeOut(),
                ) {
                    Text(
                        "≠",
                        style = MaterialTheme.typography.h4,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 6 },
                    enter = fadeIn() + expandHorizontally(expandFrom = Alignment.CenterHorizontally),
                    exit = ExitTransition.None
                ) {
                    Text(
                        "cause",
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.h4,
                    )
                }
            }
        }

        state.AnimatedVisibility(
            visible = { it >= 4 },
            enter = fadeIn() + expandHorizontally(expandFrom = Alignment.CenterHorizontally),
            exit = ExitTransition.None,
            modifier = Modifier.padding(16.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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
}
