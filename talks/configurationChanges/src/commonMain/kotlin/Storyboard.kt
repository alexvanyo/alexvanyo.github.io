import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Brush
import dev.bnorm.storyboard.SceneDecorator
import dev.bnorm.storyboard.Storyboard

fun createStoryboard() = Storyboard.build(
    title = "Handling configuration changes in Compose",
    decorator = SceneDecorator { content ->
        val colors = MaterialTheme.colors
        Surface {
            Box(
                Modifier.drawBehind {
                    drawRect(
                        Brush.radialGradient(
                            0f to colors.primary.copy(alpha = 0.4f),
                            0.3f to colors.primary.copy(alpha = 0.4f),
                            1f to colors.primary.copy(alpha = 0f),
                            center = size.toRect().bottomRight,
                            radius = size.width,
                        )
                    )
                }.fillMaxSize()
            ) {
                content()
            }
        }
    },
) {
    Scene01_TitleScene()
    Scene02_QuestionScene()
    Scene03_DefinitionsSceneSection()
}
