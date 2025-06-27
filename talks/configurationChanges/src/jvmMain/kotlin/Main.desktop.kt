import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.key
import androidx.compose.ui.window.application
import dev.bnorm.storyboard.easel.DesktopStoryEasel
import dev.bnorm.storyboard.easel.ExperimentalStoryStateApi
import dev.bnorm.storyboard.easel.rememberStoryState
import theme.TalkTheme

@OptIn(ExperimentalStoryStateApi::class)
fun main() {
    application {
        TalkTheme {
            key(isSystemInDarkTheme()) {
                val storyState = rememberStoryState()
                val storyboard = createStoryboard(storyState)
                storyState.updateStoryboard(storyboard)
                DesktopStoryEasel(storyState)
            }
        }
    }
}
