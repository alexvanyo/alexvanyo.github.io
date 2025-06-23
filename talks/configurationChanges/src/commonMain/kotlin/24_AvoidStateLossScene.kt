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
fun StoryboardBuilder.Scene24_AvoidStateLossScene() {
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
                text = AnnotatedString("Avoid state loss"),
                style = MaterialTheme.typography.h3,
            )

            Spacer(Modifier.height(32.dp))
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

                state.AnimatedVisibility(
                    visible = { it >= 1 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        "\u2022\tUsing saved instance state can be tricky or impossible",
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 2 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        buildAnnotatedString {
                            append("\t\t\u2023\tComplex or external components like ")
                            withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                                append("WebView")
                            }
                        },
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 3 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        buildAnnotatedString {
                            append("\t\t\u2023\tSaved instance state has a size limit")
                        },
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 4 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        buildAnnotatedString {
                            append("\u2022\tSolves an entire class of bugs for some configuration changes like keyboard")
                        },
                        style = MaterialTheme.typography.h5,
                    )
                }
                state.AnimatedVisibility(
                    visible = { it >= 5 },
                    enter = expandVertically(expandFrom = Alignment.Top),
                ) {
                    Text(
                        buildAnnotatedString {
                            append("\u2022\tDoesn't make saved instance state or ViewModels obsolete, just less critical")
                        },
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
        }
    }
}
