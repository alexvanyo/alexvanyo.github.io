import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application
import dev.bnorm.storyboard.easel.Animatic
import dev.bnorm.storyboard.easel.DesktopEasel
import dev.bnorm.storyboard.easel.rememberAnimatic
import theme.TalkTheme

fun main() {
    application {
        TalkTheme {
            key(isSystemInDarkTheme()) {
                var animatic: Animatic? by remember { mutableStateOf(null) }
                val storyboard = createStoryboard(
                    targetSceneIndex = { animatic?.targetIndex?.sceneIndex ?: 0 }
                )
                val currentAnimatic = rememberAnimatic("configurationChanges") { storyboard }
                SideEffect {
                    animatic = currentAnimatic
                }
                DesktopEasel(currentAnimatic)
            }
        }
    }
}
