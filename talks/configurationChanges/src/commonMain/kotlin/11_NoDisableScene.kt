import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit

@OptIn(ExperimentalTransitionApi::class)
fun StoryboardBuilder.Scene11_NoDisableScene() {
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
                "You can't disable configuration changes or opt-out of configuration changes",
                style = MaterialTheme.typography.h4,
            )
        }
    }
}
