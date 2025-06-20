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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene09_1_CurrentAndFutureScene() {
    scene(
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                buildAnnotatedString {
                    append("As of compileSdk 36, it is possible to opt-out of\nActivity recreation for ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)) { append("all") }
                    append(" configuration changes,\n")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)) { append("known") }
                    append(" and ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)) { append("future") }
                },
                style = MaterialTheme.typography.h4,
            )
        }
    }
}
