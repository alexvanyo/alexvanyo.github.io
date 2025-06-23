import ConfigurationChangeType.AssetsPaths
import ConfigurationChangeType.ColorMode
import ConfigurationChangeType.Density
import ConfigurationChangeType.FontScale
import ConfigurationChangeType.FontWeightAdjustment
import ConfigurationChangeType.GrammaticalGender
import ConfigurationChangeType.Keyboard
import ConfigurationChangeType.KeyboardHidden
import ConfigurationChangeType.LayoutDirection
import ConfigurationChangeType.Locale
import ConfigurationChangeType.Mcc
import ConfigurationChangeType.Mnc
import ConfigurationChangeType.Navigation
import ConfigurationChangeType.Orientation
import ConfigurationChangeType.ScreenLayout
import ConfigurationChangeType.ScreenSize
import ConfigurationChangeType.SmallestScreenSize
import ConfigurationChangeType.Touchscreen
import ConfigurationChangeType.UiMode
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.animateBounds
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import components.visible
import dev.bnorm.storyboard.SceneScope
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.assist.SceneCaption
import dev.bnorm.storyboard.easel.rememberSharedContentState
import dev.bnorm.storyboard.easel.sharedElement
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.toState
import theme.jetBrainsMono

@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene30_TierListScene() {
   scene(
       states = listOf(
           TierListSceneState(
               emptySet(),
               overlay = null,
           ),
           TierListSceneState(
               emptySet(),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(Touchscreen)
                       Text("\u2022\tWhether or not the window is controlled via a touch screen")
                       Text("\u2022\tChanges when the physical display changes (like with connected displays)")
                   }

                   SceneCaption {
                       Text("Safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Touchscreen,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Touchscreen,
               ),
               overlay = {
                   Column {
                       Row(
                           horizontalArrangement = Arrangement.spacedBy(4.dp),
                       ) {
                           ConfigurationChangeTypePill(Keyboard)
                           ConfigurationChangeTypePill(KeyboardHidden)
                       }
                       Text("\u2022\tThe type of physical keyboard attached (if any), and its physical state")
                       Text("\u2022\tChanges if a keyboard is attached or detached, perhaps wirelessly, or if the device posture changes")
                   }

                   SceneCaption {
                       Text("Safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(Locale)
                       Text("\u2022\tThe current language and region")
                       Text("\u2022\tChanges when the user changes languages")
                   }

                   SceneCaption {
                       Text("Riskiest")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
               ),
               overlay = {
                   Column {
                       Row(
                           horizontalArrangement = Arrangement.spacedBy(4.dp),
                       ) {
                           ConfigurationChangeTypePill(Mcc)
                           ConfigurationChangeTypePill(Mnc)
                       }
                       Text(
                           "\u2022\tThe current IMSI Mobile Country Code and Mobile Network Code",
                           Modifier.sharedElement(rememberSharedContentState("overlayMccText1")),
                       )
                       Text(
                           "\u2022\tChanges when the cellular network in use changes",
                           Modifier.sharedElement(rememberSharedContentState("overlayMccText2")),
                       )
                       Box {
                           Text(
                               "\u2022\tChanges don't cause Activity recreation unless opting in with android:recreateOnConfigChanges",
                               Modifier.visible(false),
                           )
                           androidx.compose.animation.AnimatedVisibility(
                               false,
                           ) {
                               Text(
                                   "\u2022\tChanges don't cause Activity recreation unless opting in with android:recreateOnConfigChanges",
                                   Modifier.sharedElement(rememberSharedContentState("overlayMccText3")),
                               )
                           }
                       }
                   }

                   SceneCaption {
                       Text("Extra safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
               ),
               overlay = {
                   Column {
                       Row(
                           horizontalArrangement = Arrangement.spacedBy(4.dp),
                       ) {
                           ConfigurationChangeTypePill(Mcc)
                           ConfigurationChangeTypePill(Mnc)
                       }
                       Text(
                           "\u2022\tThe current IMSI Mobile Country Code and Mobile Network Code",
                           Modifier.sharedElement(rememberSharedContentState("overlayMccText1")),
                       )
                       Text(
                           "\u2022\tChanges when the cellular network in use changes",
                           Modifier.sharedElement(rememberSharedContentState("overlayMccText2")),
                       )
                       val transitionState = remember { MutableTransitionState(false).apply { targetState = true } }
                       val transition = rememberTransition(transitionState, null)
                       transition.AnimatedVisibility(
                           visible = { it },
                           enter = fadeIn(),
                           exit = fadeOut(),
                       ) {
                           Text(
                               "\u2022\tChanges don't cause Activity recreation unless opting in with android:recreateOnConfigChanges",
                               Modifier.sharedElement(rememberSharedContentState("overlayMccText3")),
                           )
                       }
                   }

                   SceneCaption {
                       Text("Extra safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(Navigation)
                       Text("\u2022\tThe physical navigation type (trackballs, d-pad, wheel, or none)")
                   }

                   SceneCaption {
                       Text("Safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(UiMode)
                       Text("\u2022\tA combination of two things:")
                       Text("\t\t\u2023\tThe theme, dark mode or light mode")
                       Text("\t\t\u2023\tThe general \"ui mode\" - normal, TV, watch, desk, car, etc.")
                       Text("\u2022\tChanges when the theme switches (can be automatic based on time-of-day), or the user changes modes (docks a device, or enters a desktop mode)")
                   }

                   SceneCaption {
                       Text("Somewhat safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(FontScale)
                       Text("\u2022\tThe factor to adjust text sizing by")
                       Text("\u2022\tNon-linear since Android 15 - don't just multiply to convert sp to dp anymore")
                       Text("\u2022\tChanges when the user changes font size in accessibility")
                   }

                   SceneCaption {
                       Text("Somewhat safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
               ),
               overlay = {
                   Column {
                       Row(
                           horizontalArrangement = Arrangement.spacedBy(4.dp),
                       ) {
                           ConfigurationChangeTypePill(ScreenSize)
                           ConfigurationChangeTypePill(SmallestScreenSize)
                           ConfigurationChangeTypePill(ScreenLayout)
                           ConfigurationChangeTypePill(Orientation)
                       }
                       Text(
                           buildAnnotatedString {
                               append("\u2022\t")
                               withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                                   append("Screen")
                               }
                               append(" Window size, layout and and orientation")
                           }
                       )
                       Text("\u2022\tChanges when the window is resized, which could be from multi-window modes," +
                               " device rotation, folding/unfolding, switching displays, or density changes")
                   }

                   SceneCaption {
                       Text("Somewhat safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(Density)
                       Text("\u2022\tThe density of the window - the multiplier to convert from dp to px")
                       Text("\u2022\tChanges when the density of the display changes, or the app switches displays")
                   }

                   SceneCaption {
                       Text("Fairly risky")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(FontWeightAdjustment)
                       Text("\u2022\tAn adjustment to the weight of a font")
                       Text("\u2022\tChanges when the font weight is changed in accessibility settings")
                   }

                   SceneCaption {
                       Text("Somewhat safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(LayoutDirection)
                       Text("\u2022\tThe layout direction of the window: left-to-right or right-to-left")
                       Text("\u2022\tChanges when the locale changes")
                   }

                   SceneCaption {
                       Text("Riskiest")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
                   LayoutDirection,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
                   LayoutDirection,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(ColorMode)
                       Text("\u2022\tThe color mode capabilities of the window: wide gamut and/or HDR")
                       Text("\u2022\tChanges when the display changes")
                   }

                   SceneCaption {
                       Text("Safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
                   LayoutDirection,
                   ColorMode,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
                   LayoutDirection,
                   ColorMode,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(GrammaticalGender)
                       Text("\u2022\tThe user's grammatical gender")
                       Text("\u2022\tChanges when requested by the user or application, such as if the user account changes")
                   }

                   SceneCaption {
                       Text("Riskiest")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
                   LayoutDirection,
                   ColorMode,
                   GrammaticalGender,
               ),
               overlay = null,
           ),
           TierListSceneState(
               setOf(
                   Locale,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   Mcc,
                   Mnc,
                   Navigation,
                   UiMode,
                   FontScale,
                   ScreenLayout,
                   ScreenSize,
                   Orientation,
                   SmallestScreenSize,
                   Density,
                   FontWeightAdjustment,
                   LayoutDirection,
                   ColorMode,
                   GrammaticalGender,
               ),
               overlay = {
                   Column {
                       ConfigurationChangeTypePill(AssetsPaths)
                       Text("")
                       Text("\u2022\tChanges when the assets paths change... like if the background wallpaper changes")
                       Text("\u2022\tThis configuration change has existed since Android 12 (API 31), but the constant was made public in Android 16 (API 36)")
                       Text("\u2022\tOpting out of recreation will opt-out of recreation for it all the way back to Android 12")
                   }

                   SceneCaption {
                       Text("Safe")
                   }
               },
           ),
           TierListSceneState(
               setOf(
                   Density,
                   Locale,
                   GrammaticalGender,
                   LayoutDirection,
                   ScreenSize,
                   SmallestScreenSize,
                   ScreenLayout,
                   Orientation,
                   FontScale,
                   FontWeightAdjustment,
                   UiMode,
                   Touchscreen,
                   Keyboard,
                   KeyboardHidden,
                   AssetsPaths,
                   Navigation,
                   ColorMode,
                   Mcc,
                   Mnc,
               ),
               overlay = null,
           )
       ),
       enterTransition = SceneEnter(Alignment.CenterEnd),
       exitTransition = SceneExit(Alignment.CenterEnd),
   ) {
       TierListSceneContent()
   }
}

context(_: AnimatedVisibilityScope, scope: SharedTransitionScope)
@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class, ExperimentalAnimationApi::class)
@Composable
private fun SceneScope<TierListSceneState>.TierListSceneContent() {
    val state = transition.createChildTransition { it.toState() }

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            Divider(Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RiskLabel(4)
                ConfigurationChangeTypeRow(state, 4)
            }
            Divider(Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RiskLabel(3)
                ConfigurationChangeTypeRow(state, 3)
            }
            Divider(Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RiskLabel(2)
                ConfigurationChangeTypeRow(state, 2)
            }
            Divider(Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RiskLabel(1)
                ConfigurationChangeTypeRow(state, 1)
            }
            Divider(Modifier.fillMaxWidth())
            Row(Modifier.weight(1f)) {
                state.AnimatedVisibility(
                    visible = { it.displayedConfigurationChangeType.any { it.risk == 0 } },
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RiskLabel(0)
                        ConfigurationChangeTypeRow(state, 0)
                    }
                }
            }
            Box(Modifier.fillMaxWidth().height(1.dp)) {
                state.AnimatedVisibility(
                    visible = { it.displayedConfigurationChangeType.any { it.risk == 0 } },
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    Divider(Modifier.fillMaxWidth())
                }
            }
        }

        state.AnimatedContent(
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            },
            contentAlignment = Alignment.Center,
        ) { targetState ->
            val overlay = targetState.overlay
            if (overlay == null) {
                Spacer(Modifier.fillMaxSize())
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                        .sharedElement(rememberSharedContentState("overlay")),
                    contentAlignment = Alignment.Center,
                ) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        modifier =
                            Modifier
                                .padding(128.dp)
                                .sharedElement(rememberSharedContentState("overlayCard")),
                    ) {
                        Box(Modifier.padding(16.dp)) {
                            overlay()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
data class TierListSceneState(
    val displayedConfigurationChangeType: Set<ConfigurationChangeType>,
    val overlay: (@Composable context(AnimatedVisibilityScope, SharedTransitionScope) () -> Unit)?,
)

context(_: AnimatedVisibilityScope, scope: SharedTransitionScope)
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun ConfigurationChangeTypeRow(
    state: Transition<TierListSceneState>,
    risk: Int,
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.CenterVertically),
        modifier = Modifier.padding(4.dp).fillMaxSize(),
    ) {
        ConfigurationChangeType.entries.filter { it.risk == risk }.forEach { configurationChangeType ->
            state.AnimatedVisibility(
                visible = { configurationChangeType in it.displayedConfigurationChangeType },
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.animateBounds(scope),
            ) {
                ConfigurationChangeTypePill(
                    configurationChangeType = configurationChangeType,
                )
            }
        }
    }
}

@Composable
private fun RiskLabel(
    risk: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .width(128.dp)
            .background(
                color = when (risk) {
                    0 -> Color(0xff7fffff)
                    1 -> Color(0xffbfff7f)
                    2 -> Color(0xffffff7f)
                    3 -> Color(0xffffbf7f)
                    else -> Color(0xffff6666)
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            when (risk) {
                0 -> "Extra safe"
                1 -> "Safe"
                2 -> "Somewhat safe"
                3 -> "Fairly risky"
                else -> "Riskiest"
            },
            color = MaterialTheme.colors.onPrimary,
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
context(_: AnimatedVisibilityScope, scope: SharedTransitionScope)
@Composable
private fun ConfigurationChangeTypePill(
    configurationChangeType: ConfigurationChangeType,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(percent = 100),
        modifier = modifier.sharedElement(
            sharedContentState = rememberSharedContentState(key = configurationChangeType),
            zIndexInOverlay = 100f,
        ),
    ) {
        Text(
            when (configurationChangeType) {
                Density -> "density"
                Locale -> "locale"
                GrammaticalGender -> "grammaticalGender"
                LayoutDirection -> "layoutDirection"
                ScreenSize -> "screenSize"
                SmallestScreenSize -> "smallestScreenSize"
                ScreenLayout -> "screenLayout"
                Orientation -> "orientation"
                FontScale -> "fontScale"
                FontWeightAdjustment -> "fontWeightAdjustment"
                UiMode -> "uiMode"
                Touchscreen -> "touchscreen"
                Keyboard -> "keyboard"
                KeyboardHidden -> "keyboardHidden"
                AssetsPaths -> "assetsPaths"
                Navigation -> "navigation"
                ColorMode -> "colorMode"
                Mcc -> "mcc"
                Mnc -> "mnc"
            },
            fontFamily = jetBrainsMono,
            modifier = Modifier.padding(4.dp)
        )
    }
}

enum class ConfigurationChangeType(
    val risk: Int,
) {
    Locale(4),
    LayoutDirection(4),
    GrammaticalGender(4),
    Density(3),
    UiMode(2),
    FontScale(2),
    ScreenSize(2),
    SmallestScreenSize(2),
    ScreenLayout(2),
    Orientation(2),
    FontWeightAdjustment(2),
    Touchscreen(1),
    Keyboard(1),
    KeyboardHidden(1),
    Navigation(1),
    ColorMode(1),
    AssetsPaths(1),
    Mcc(0),
    Mnc(0)
}
