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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState
import theme.jetBrainsMono

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene16_SnapshotStateBackedConfigurationLocals() {
    scene(
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Column(
            modifier = Modifier.padding(32.dp).fillMaxSize(),
        ) {
                Text(
                    text = buildAnnotatedString {
                        append("Composition locals derived from ")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalConfiguration.current")
                        }
                        append(":")
                    },
                    style = MaterialTheme.typography.h3,
                )

            Spacer(Modifier.height(32.dp))
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    buildAnnotatedString {
                        append("\u2022\t")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalDensity")
                        }
                    },
                    style = MaterialTheme.typography.h5,
                )
                Text(
                    buildAnnotatedString {
                        append("\u2022\t")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalResources")
                        }
                    },
                    style = MaterialTheme.typography.h5,
                )
                Text(
                    buildAnnotatedString {
                        append("\u2022\t")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalLayoutDirection")
                        }
                    },
                    style = MaterialTheme.typography.h5,
                )
                Text(
                    buildAnnotatedString {
                        append("\u2022\t")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalFontFamilyResolver")
                        }
                    },
                    style = MaterialTheme.typography.h5,
                )
                Text(
                    buildAnnotatedString {
                        append("\u2022\t")
                        withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                            append("LocalWindowInfo")
                        }
                    },
                    style = MaterialTheme.typography.h5,
                )
            }
        }
    }
}
