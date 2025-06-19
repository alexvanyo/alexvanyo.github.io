import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import components.animateContentSize
import dev.bnorm.storyboard.SceneScope
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.rememberSharedContentState
import dev.bnorm.storyboard.easel.sharedElement
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState
import theme.jetBrainsMono

@OptIn(ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene10_DefinitionsScene3() {
    scene(
        stateCount = 2,
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        DefinitionsScene3Content()
    }
}

private val changesSharedElementKey = Any()
private val configurationSharedElementKey = Any()

context(_: AnimatedVisibilityScope, scope: SharedTransitionScope)
@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class, ExperimentalAnimationApi::class)
@Composable
private fun SceneScope<Int>.DefinitionsScene3Content() {
    val state = transition.createChildTransition { it.toState() }
    Row(
        Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            state.AnimatedContent(
                contentAlignment = Alignment.CenterStart,
            ) {
                when (it) {
                    0 -> {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp),
                        ) {
                            Text(
                                "Configuration",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.sharedElement(rememberSharedContentState(configurationSharedElementKey)),
                            )
                            Text(
                                "Changes",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.sharedElement(rememberSharedContentState(changesSharedElementKey)),
                            )
                        }
                    }
                    else -> {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp),
                        ) {
                            Text(
                                "Configuration",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.sharedElement(rememberSharedContentState(configurationSharedElementKey)),
                            )
                            Text(
                                "Changes",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.sharedElement(rememberSharedContentState(changesSharedElementKey)),
                            )
                            Text(
                                "with",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                            Text(
                                "android:configChanges",
                                style = MaterialTheme.typography.h5,
                                fontFamily = jetBrainsMono,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            state.AnimatedVisibility(
                visible = { it == 0 },
                enter = EnterTransition.None,
                exit = fadeOut() + shrinkOut(shrinkTowards = Alignment.BottomCenter),
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

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            state.AnimatedContent(
                contentAlignment = Alignment.CenterStart,
            ) {
                when (it) {
                    0 -> {
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
                    else -> {
                        Text(
                            "onConfigurationChanged",
                            style = MaterialTheme.typography.h5,
                            fontFamily = jetBrainsMono,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}
