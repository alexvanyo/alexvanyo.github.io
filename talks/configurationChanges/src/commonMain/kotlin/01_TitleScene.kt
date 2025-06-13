import androidx.compose.ui.text.AnnotatedString
import dev.bnorm.storyboard.StoryboardBuilder
import templates.TitleSceneTemplate

fun StoryboardBuilder.Scene01_TitleScene() {
    TitleSceneTemplate(
        AnnotatedString("Handling Configuration Changes\nin Compose"),
        AnnotatedString("Alex Vanyo\nSoftware Engineer @ Google"),
    )
}
