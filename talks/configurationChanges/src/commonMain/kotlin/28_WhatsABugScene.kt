import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import theme.LocalEmojiFontFamily

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene28_WhatsABugScene() {
    scene(
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                buildAnnotatedString {
                    append("If Compose itself, or a Compose library,\nexpects recreation to happen to function correctly,\nthat's a bug ")
                    withStyle(SpanStyle(fontFamily = LocalEmojiFontFamily.current)) {
                        append("\uD83D\uDC1B")
                    }
                },
                style = MaterialTheme.typography.h4,
            )
        }
    }
}
