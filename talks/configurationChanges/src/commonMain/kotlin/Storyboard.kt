import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
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
        val highlightColor by animateColorAsState(
            borderColors[storyState.targetIndex.sceneIndex.mod(borderColors.size)],
            animationSpec = spring(stiffness = Spring.StiffnessLow)
        )
        CompositionLocalProvider(LocalHighlightColor provides { highlightColor }) {
            Surface {
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
                            color = highlightColor,
                            style = Stroke(width = 4.dp.toPx()),
                        )
                    }.fillMaxSize()
                ) {
                    content()
                }
            }
        }
    },
) {
    Scene01_TitleScene()
    Scene02_QuestionScene()
    Scene03_DefinitionsScene1()
    Scene04_WhyScene1()
    Scene05_ArchitectureGoalsScene()
    Scene06_WhyScene2()
    Scene07_ResourcesScene()
    Scene08_DefinitionsScene2()
    Scene09_AndroidConfigChangesScene()
    Scene09_1_CurrentAndFutureScene()
    Scene09_2_NotActivityRecreation()
    Scene10_DefinitionsScene4()
    Scene11_NoDisableScene()
    Scene11_1_PromiseScene()
    Scene12_OnConfigurationChangedScene()
    Scene13_ItsComposeScene()
    Scene14_ComposeViewImpl()
    Scene15_HowToHandleConfigurationChangesInCompose()
    Scene16_SnapshotStateBackedConfigurationLocals()
    Scene17_Example1_RawResources()
    Scene18_Example2_NumberFormatting()
    Scene19_Example3_DateFormatting()
    Scene20_Example4_AndroidView()
    Scene21_Example5_AnchoredDraggable()
    Scene22_Example6_TestingScene()
    Scene23_WhyCareScene()
    Scene24_AvoidStateLossScene()
    Scene25_PerformanceScene()
    Scene26_AnimateChanges()
    Scene27_HowToOptOutOfRecreationsScene()
    Scene28_WhatsABugScene()
    Scene30_TierListScene()
    Scene97_QuestionScene2()
    Scene98_ConclusionScene()
    Scene99_ThankYouScene()
}

val LocalHighlightColor: ProvidableCompositionLocal<() -> Color> = compositionLocalOf {
    error("highlightColor not set")
}
