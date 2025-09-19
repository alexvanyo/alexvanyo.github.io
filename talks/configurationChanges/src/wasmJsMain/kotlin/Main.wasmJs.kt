import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.key
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.bnorm.storyboard.easel.ExperimentalStoryStateApi
import dev.bnorm.storyboard.easel.WebStoryEasel
import dev.bnorm.storyboard.easel.rememberStoryState
import kotlinx.browser.document
import org.w3c.dom.HTMLElement
import theme.TalkTheme

@OptIn(ExperimentalComposeUiApi::class, ExperimentalStoryStateApi::class)
fun main() {
    val element = document.getElementById("composeApp") as HTMLElement
    element.title = "Handling configuration changes in Compose"
    element.focus() // Focus is required for keyboard navigation.
    ComposeViewport(
        viewportContainer = element,
    ) {
        TalkTheme {
            key(isSystemInDarkTheme()) {
                val storyState = rememberStoryState()
                val storyboard = createStoryboard(storyState)
                storyState.updateStoryboard(storyboard)
                WebStoryEasel(storyState)
            }
        }
    }
}
