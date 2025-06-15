import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import dev.bnorm.storyboard.LocalStoryboard
import dev.bnorm.storyboard.easel.ExperimentalStoryStateApi
import dev.bnorm.storyboard.easel.WebStoryEasel
import dev.bnorm.storyboard.easel.rememberStoryState
import kotlinx.browser.document
import org.w3c.dom.HTMLCanvasElement
import theme.TalkTheme

@OptIn(ExperimentalComposeUiApi::class, ExperimentalStoryStateApi::class)
fun main() {
    val element = document.getElementById("ComposeTarget") as HTMLCanvasElement
    element.focus() // Focus is required for keyboard navigation.
    CanvasBasedWindow(canvasElementId = element.id, title = "Handling configuration changes in Compose") {
        val storyState = rememberStoryState()
        val storyboard = createStoryboard(storyState)
        TalkTheme {
            storyState.updateStoryboard(storyboard)
            WebStoryEasel(storyState)
        }
    }
}
