import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import theme.jetBrainsMono

fun StoryboardBuilder.Scene02_QuestionScene() {
    scene(
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Column(
            modifier = Modifier.padding(32.dp).fillMaxSize(),
        ) {
            Text(
                buildAnnotatedString {
                    append("What should you put in ")
                    withStyle(SpanStyle(fontFamily = jetBrainsMono)) {
                        append("android:configChanges")
                    }
                    append("?")
                },
                style = MaterialTheme.typography.h3,
            )
            Spacer(Modifier.height(32.dp))
            Text("This talk is about that, but be patient")
        }
    }
}
