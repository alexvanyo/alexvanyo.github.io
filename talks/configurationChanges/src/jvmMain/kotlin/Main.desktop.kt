import androidx.compose.ui.window.application
import dev.bnorm.storyboard.easel.DesktopStoryEasel
import theme.TalkTheme

fun main() {
    val storyboard = createStoryboard()
    application {
        TalkTheme {
            DesktopStoryEasel(storyboard)
        }
    }
}
