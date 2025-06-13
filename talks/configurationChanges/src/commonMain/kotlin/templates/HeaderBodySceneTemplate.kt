package templates

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.AdvanceDirection
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit

fun StoryboardBuilder.HeaderBodySceneTemplate(
    header: AnnotatedString,
    enterTransition: (AdvanceDirection) -> EnterTransition = SceneEnter(Alignment.CenterEnd),
    exitTransition: (AdvanceDirection) -> ExitTransition = SceneExit(Alignment.CenterEnd),
    body: @Composable () -> Unit,
) {
    scene(
        enterTransition = enterTransition,
        exitTransition = exitTransition,
    ) {
        Column(
            modifier = Modifier.padding(32.dp).fillMaxSize(),
        ) {
            Text(
                header,
                style = MaterialTheme.typography.h3,
            )
            Spacer(Modifier.height(32.dp))
            body()
        }
    }
}
