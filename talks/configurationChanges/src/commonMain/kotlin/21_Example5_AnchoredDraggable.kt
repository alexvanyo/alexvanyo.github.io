import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.Draggable2DState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import components.animateContentSize
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import dev.bnorm.storyboard.text.highlight.CodeStyle
import dev.bnorm.storyboard.text.highlight.Language
import dev.bnorm.storyboard.text.highlight.highlight
import dev.bnorm.storyboard.text.magic.MagicText
import dev.bnorm.storyboard.toState
import theme.INTELLIJ_DARK_CODE_STYLE
import theme.jetBrainsMono
import kotlin.math.roundToInt

@OptIn(ExperimentalTransitionApi::class, ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene22_Example6_TestingScene() {
    val kotlinHighlighting = INTELLIJ_DARK_CODE_STYLE
    scene(
        states = listOf(
            listOf(
                "enum class Anchors { Start, Center, End }\n",
                "\n",
                "val state = rememberSaveable(AnchoredDraggableState.Saver<Anchors>()) {\n",
                "    AnchoredDraggableState(initialValue = Anchors.Center)\n",
                "}",
            ).highlight(kotlinHighlighting),
            listOf(
                "enum class Anchors { Start, Center, End }\n",
                "\n",
                "val state = rememberSaveable(AnchoredDraggableState.Saver<Anchors>()) {\n",
                "    AnchoredDraggableState(initialValue = Anchors.Center)\n",
                "}", "\n",
                "\n",
                "Box", " ", "{", "\n",
                "\n",
                "}"
            ).highlight(kotlinHighlighting),
            listOf(
                "enum class Anchors { Start, Center, End }\n",
                "\n",
                "val state = rememberSaveable(AnchoredDraggableState.Saver<Anchors>()) {\n",
                "    AnchoredDraggableState(initialValue = Anchors.Center)\n",
                "}", "\n",
                "\n",
                "Box", " ", "{", "\n",
                "    ", "Spacer(", "\n",
                "        Modifier\n",
                "            .size(32.dp)\n",
                "            .offset { IntOffset(x = state.requireOffset().roundToInt(), y = 0) }\n",
                "            .anchoredDraggable(state = state, orientation = Orientation.Horizontal)\n",
                "            .background(Color.Red)\n",
                "    ", ")", "\n",
                "}"
            ).highlight(kotlinHighlighting),
            listOf(
                "val state = rememberSaveable(AnchoredDraggableState.Saver<Anchors>()) {\n",
                "    AnchoredDraggableState(initialValue = Anchors.Center)\n",
                "}", "\n",
                "\n",
                "Box", "(", "\n",
                "    modifier.layout { measurable, constraints ->\n",
                "        val placeable = measurable.measure(constraints)\n",
                "        layout(placeable.width, placeable.height) {\n",
                "            placeable.placeRelative(0, 0)\n",
                "        }\n",
                "    },\n",
                ") ", "{", " ", "Spacer(", "/* ... */", ")", " ", "}",
            ).highlight(kotlinHighlighting),
            listOf(
                "Box", "(", "\n",
                "    modifier.layout { measurable, constraints ->\n",
                "        val placeable = measurable.measure(constraints)\n",
                "        val dragEndPoint = placeable.width - 32.dp.toPx()\n",
                "        val newAnchors = DraggableAnchors {", "\n",
                "            Anchors.Start at 0f\n",
                "            Anchors.Center at dragEndPoint * .5f\n",
                "            Anchors.End at dragEndPoint\n",
                "       ", " }", "\n",
                "        state.updateAnchors(", "newAnchors = newAnchors" , ")", "\n",
                "        layout(placeable.width, placeable.height) {\n",
                "            placeable.placeRelative(0, 0)\n",
                "        }\n",
                "    },\n",
                ") ", "{", " ", "Spacer(", "/* ... */", ")", " ", "}",
            ).highlight(kotlinHighlighting),
            listOf(
                "Box", "(", "/* ... */", ") ", "{", " ", "Spacer(", "/* ... */", ")", " ", "}",
            ).highlight(kotlinHighlighting),
            listOf(
                "Box", "(", "\n",
                "    modifier.layout { measurable, constraints ->\n",
                "        val placeable = measurable.measure(constraints)\n",
                "        val dragEndPoint = placeable.width - 32.dp.toPx()\n",
                "        val newAnchors = DraggableAnchors {", "\n",
                "            Anchors.Start at 0f\n",
                "            Anchors.Center at dragEndPoint * .5f\n",
                "            Anchors.End at dragEndPoint\n",
                "       ", " }", "\n",
                "        state.updateAnchors(", "newAnchors = newAnchors" , ")", "\n",
                "        layout(placeable.width, placeable.height) {\n",
                "            placeable.placeRelative(0, 0)\n",
                "        }\n",
                "    },\n",
                ") ", "{", " ", "Spacer(", "/* ... */", ")", " ", "}",
            ).highlight(kotlinHighlighting),
            listOf(
                "Box", "(", "\n",
                "    modifier.layout { measurable, constraints ->\n",
                "        val placeable = measurable.measure(constraints)\n",
                "        val dragEndPoint = placeable.width - 32.dp.toPx()\n",
                "        val newAnchors = DraggableAnchors {", " /* ... */", " }", "\n",
                "        state.updateAnchors(", "\n",
                "            ", "newAnchors = newAnchors", ",", "\n",
                "            newTarget = ", "if (!state.offset.isNaN()) {\n",
                "                newAnchors.closestAnchor(state.offset) ?: state.targetValue\n",
                "            } else state.targetValue,\n",
                "        ", ")", "\n",
                "        layout(placeable.width, placeable.height) {\n",
                "            placeable.placeRelative(0, 0)\n",
                "        }\n",
                "    },\n",
                ") ", "{", " ", "Spacer(", "/* ... */", ")", " ", "}",
            ).highlight(kotlinHighlighting),
            listOf(
                "Box", "(", "\n",
                "    modifier.layout { measurable, constraints ->\n",
                "        val placeable = measurable.measure(constraints)\n",
                "        val dragEndPoint = placeable.width - 32.dp.toPx()\n",
                "        val newAnchors = DraggableAnchors {", " /* ... */", " }", "\n",
                "        state.updateAnchors(", "\n",
                "            ", "newAnchors = newAnchors", ",", "\n",
                "            newTarget = ", "state.targetValue", "\n",
                "        ", ")", "\n",
                "        layout(placeable.width, placeable.height) {\n",
                "            placeable.placeRelative(0, 0)\n",
                "        }\n",
                "    },\n",
                ") ", "{", " ", "Spacer(", "/* ... */", ")", " ", "}",
            ).highlight(kotlinHighlighting),
            listOf(
                "Box", "(", "/* ... */", ") ", "{", " ", "Spacer(", "/* ... */", ")", " ", "}",
            ).highlight(kotlinHighlighting),
        ).withIndex().toList(),
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(64.dp),
        ) {
            val kotlinCodeTransition = transition.createChildTransition { it.toState().value }
            ProvideTextStyle(TextStyle(fontFamily = jetBrainsMono)) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .animateContentSize(
                            clip = false,
                        )
                ) {
                    MagicText(
                        kotlinCodeTransition,
                    )
                }
            }

            val indexTransition = transition.createChildTransition { it.toState().index }

            indexTransition.AnimatedVisibility(
                visible = { it == 5 },
                modifier = Modifier.align(Alignment.BottomCenter),
                enter = fadeIn(tween(durationMillis = 220, delayMillis = 400)),
                exit = fadeOut(),
            ) {
                ResizableBox {
                    AnchoredDraggableDemo(modifier = Modifier.fillMaxSize(), isCorrect = false)
                }
            }

            indexTransition.AnimatedVisibility(
                visible = { it == 9 },
                modifier = Modifier.align(Alignment.BottomCenter),
                enter = fadeIn(tween(durationMillis = 220, delayMillis = 400)),
                exit = fadeOut(),
            ) {
                ResizableBox {
                    AnchoredDraggableDemo(modifier = Modifier.fillMaxSize(), isCorrect = true)
                }
            }
        }
    }
}

private enum class Anchors { Start, Center, End }

@Composable
private fun ResizableBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val maxX = 800.dp
    val maxY = 200.dp
    val (minXPx, maxXPx) = with(LocalDensity.current) { 100.dp.toPx() to maxX.toPx() }
    val (minYPx, maxYPx) = with(LocalDensity.current) { 100.dp.toPx() to maxY.toPx() }
    var offsetPositionX by remember { mutableStateOf(maxXPx) }
    var offsetPositionY by remember { mutableStateOf(maxYPx) }

    var isDragInProgress by remember { mutableStateOf(false) }
    var offsetId by remember { mutableStateOf(0) }

    val finishedOffsetPositionX = remember(offsetId) { offsetPositionX }
    val finishedOffsetPositionY = remember(offsetId) { offsetPositionY }

    Box(
        modifier =
            modifier
                .width(maxX)
                .height(maxY)
    ) {
        Box(
            modifier = Modifier
                .width(with(LocalDensity.current) { finishedOffsetPositionX.toDp() })
                .height(with(LocalDensity.current) { finishedOffsetPositionY.toDp() })
                .border(width = 2.dp, color = MaterialTheme.colors.onSurface)
        ) {
            content()
        }

        AnimatedVisibility(
            isDragInProgress,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Spacer(
                Modifier
                    .width(with(LocalDensity.current) { offsetPositionX.toDp() })
                    .height(with(LocalDensity.current) { offsetPositionY.toDp() })
                    .border(width = 2.dp, color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
            )
        }

        Box(
            Modifier
                .offset {
                    IntOffset(offsetPositionX.roundToInt(), offsetPositionY.roundToInt())
                }
                .graphicsLayer {
                    translationX = -size.width / 2
                    translationY = -size.height / 2
                }
                .size(24.dp)
                .draggable2D(
                    state =
                        rememberDraggable2DState { delta ->
                            val newValueX = offsetPositionX + delta.x
                            val newValueY = offsetPositionY + delta.y
                            offsetPositionX = newValueX.coerceIn(minXPx, maxXPx)
                            offsetPositionY = newValueY.coerceIn(minYPx, maxYPx)
                        },
                    onDragStarted = {
                        isDragInProgress = true
                    },
                    onDragStopped = {
                        isDragInProgress = false
                        offsetId++
                    },
                )
                .background(MaterialTheme.colors.onSurface, shape = CircleShape)
        )
    }
}

@Composable
private fun AnchoredDraggableDemo(
    modifier: Modifier = Modifier,
    isCorrect: Boolean = false,
) {
    val state = rememberSaveable(AnchoredDraggableState.Saver<Anchors>()) {
        AnchoredDraggableState(initialValue = Anchors.Center)
    }

    Box(
        modifier
            .layout { measurable, constraints ->
                val placeable = measurable.measure(constraints)

                val dragEndPoint = placeable.width - 32.dp.toPx()
                val newAnchors = DraggableAnchors {
                    Anchors.Start at 0f
                    Anchors.Center at dragEndPoint * .5f
                    Anchors.End at dragEndPoint
                }
                state.updateAnchors(
                    newAnchors = newAnchors,
                    newTarget = if (isCorrect) {
                        state.targetValue
                    } else {
                        if (!state.offset.isNaN()) {
                            newAnchors.closestAnchor(state.offset) ?: state.targetValue
                        } else state.targetValue
                    },
                )

                layout(placeable.width, placeable.height) {
                    placeable.placeRelative(0, 0)
                }
            },
        contentAlignment = Alignment.CenterStart,
    ) {
        Spacer(
            Modifier
                .size(32.dp)
                .offset { IntOffset(x = state.requireOffset().roundToInt(), y = 0) }
                .anchoredDraggable(state = state, orientation = Orientation.Horizontal)
                .background(Color.Red)
        )
    }
}

private fun List<String>.highlight(
    codeStyle: CodeStyle,
): List<AnnotatedString> {
    val merged = joinToString("")
    val highlighted = merged.highlight(
        codeStyle = codeStyle,
        language = Language.Kotlin,
    )

    val split = buildList {
        var index = 0
        for (element in this@highlight) {
            this.add(highlighted.subSequence(index, index + element.length))
            index += element.length
        }
    }

    return split
}

