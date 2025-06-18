import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import templates.HeaderBodySceneTemplate

fun StoryboardBuilder.Scene05_ArchitectureGoalsScene() {
    HeaderBodySceneTemplate(
        header = AnnotatedString("Top 5 reasons to have an architecture:"),
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterStart),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                "\u2022\tBetter testability",
                style = MaterialTheme.typography.h5,
            )
            Text(
                "\u2022\tSpark never-ending social media feuds",
                style = MaterialTheme.typography.h5,
            )
            Text(
                "\u2022\tManage a single-source of truth for state",
                style = MaterialTheme.typography.h5,
            )
            Text(
                "\u2022\tDeal with Android component lifecycles",
                style = MaterialTheme.typography.h5,
                color = LocalHighlightColor.current.invoke(),
            )
            Text(
                "\u2022\tManage scopes for dependency injection",
                style = MaterialTheme.typography.h5,
            )
        }
    }
}
