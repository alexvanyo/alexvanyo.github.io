import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.bnorm.storyboard.easel.Animatic
import dev.bnorm.storyboard.easel.WebEasel
import dev.bnorm.storyboard.easel.rememberAnimatic
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import theme.TalkTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val element = document.getElementById("composeApp") as HTMLElement
    element.title = "Handling configuration changes in Compose"
    element.focus() // Focus is required for keyboard navigation.
    ComposeViewport(
        viewportContainer = element,
    ) {
        TalkTheme {
            key(isSystemInDarkTheme()) {
                var animatic: Animatic? by remember { mutableStateOf(null) }
                val storyboard = createStoryboard(
                    targetSceneIndex = { animatic?.targetIndex?.sceneIndex ?: 0 }
                )
                val currentAnimatic = rememberAnimatic(window) { storyboard }
                SideEffect {
                    animatic = currentAnimatic
                }
                WebEasel(currentAnimatic)
            }
        }
    }
}
