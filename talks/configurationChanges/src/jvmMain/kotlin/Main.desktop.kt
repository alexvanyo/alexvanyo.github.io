import androidx.compose.ui.window.application
import dev.bnorm.storyboard.easel.DesktopStoryEasel
import dev.bnorm.storyboard.easel.ExperimentalStoryStateApi
import dev.bnorm.storyboard.easel.rememberStoryState
import theme.TalkTheme

@OptIn(ExperimentalStoryStateApi::class)
fun main() {
    application {
        val storyState = rememberStoryState()
        val storyboard = createStoryboard(storyState)
        TalkTheme {
            storyState.updateStoryboard(storyboard)
            DesktopStoryEasel(storyState)
        }
    }
}
