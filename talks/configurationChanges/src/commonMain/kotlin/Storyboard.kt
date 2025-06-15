import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.SceneDecorator
import dev.bnorm.storyboard.Storyboard
import dev.bnorm.storyboard.easel.StoryState

fun createStoryboard(
    storyState: StoryState,
) = Storyboard.build(
    title = "Handling configuration changes in Compose",
    decorator = SceneDecorator { content ->
        // Google Blue, Red, Yellow and Green
        val borderColors = listOf(
            Color(0xFF4285F4),
            Color(0xFFDB4437),
            Color(0xFFF4B400),
            Color(0xFF0F9D58),
        )
        Surface {
            val borderColor by animateColorAsState(
                borderColors[storyState.targetIndex.sceneIndex.mod(borderColors.size)],
                animationSpec = spring(stiffness = Spring.StiffnessLow)
            )
            Box(
                Modifier.drawWithContent {
                    val borderPath = Path().apply {
                        addRoundRect(
                            RoundRect(
                                size.toRect().deflate(8.dp.toPx()),
                                cornerRadius = CornerRadius(8.dp.toPx()),
                            )
                        )
                    }

                    clipPath(borderPath) {
                        this@drawWithContent.drawContent()
                    }
                    drawPath(
                        path = borderPath,
                        color = borderColor,
                        style = Stroke(width = 4.dp.toPx()),
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
    Scene10_TierListScene()
    Scene99_ThankYouScene()
}
