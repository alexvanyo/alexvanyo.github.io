package components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotateRad
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toOffset
import kotlin.math.PI
import kotlin.math.atan2

@Composable
fun LineCanvas(
    lines: List<Line>,
    modifier: Modifier,
) {
    val canvasLayoutBoundsHolder = remember { LayoutCoordinatesHolder() }
    val layoutDirection = LocalLayoutDirection.current

    fun Line.calculateStartOffsetInLocal(): Offset =
        canvasLayoutBoundsHolder.coordinates!!.localPositionOf(
            start.coordinates!!,
            startAlignment.align(
                size = IntSize.Zero,
                space = start.coordinates!!.size,
                layoutDirection = layoutDirection,
            ).toOffset(),
        )

    fun Line.calculateEndOffsetInLocal(): Offset =
        canvasLayoutBoundsHolder.coordinates!!.localPositionOf(
            end.coordinates!!,
            endAlignment.align(
                size = IntSize.Zero,
                space = end.coordinates!!.size,
                layoutDirection = layoutDirection,
            ).toOffset(),
        )

    Box(
        modifier = modifier
            .layoutCoordinates(canvasLayoutBoundsHolder)
            .drawBehind {
                lines.forEach { arrow ->
                    val startOffsetInLocal = arrow.calculateStartOffsetInLocal()
                    val endOffsetInLocal = arrow.calculateEndOffsetInLocal()
                    val difference = endOffsetInLocal - startOffsetInLocal
                    val length = difference.getDistance()
                    withTransform(
                        {
                            rotateRad(atan2(difference.y, difference.x), pivot = startOffsetInLocal)
                            inset(
                                left = startOffsetInLocal.x,
                                top = startOffsetInLocal.y,
                                right = size.width - (startOffsetInLocal.x + length),
                                bottom = size.height - startOffsetInLocal.y,
                            )
                        }
                    ) {
                        arrow.drawBody(this)
                    }
                }
            }
    ) {
        lines.forEach { arrow ->
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        val startOffsetInLocal = arrow.calculateStartOffsetInLocal()
                        val endOffsetInLocal = arrow.calculateEndOffsetInLocal()
                        val difference = endOffsetInLocal - startOffsetInLocal
                        this.translationX = startOffsetInLocal.x - size.width
                        this.translationY = startOffsetInLocal.y - size.height / 2
                        transformOrigin = TransformOrigin(1f, 0.5f)
                        this.rotationZ = atan2(difference.y, difference.x).toDegrees() + 180f
                    }
            ) {
                arrow.lineStart?.invoke()
            }
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        val startOffsetInLocal = arrow.calculateStartOffsetInLocal()
                        val endOffsetInLocal = arrow.calculateEndOffsetInLocal()
                        val difference = endOffsetInLocal - startOffsetInLocal
                        this.translationX = endOffsetInLocal.x - size.width
                        this.translationY = endOffsetInLocal.y - size.height / 2
                        this.transformOrigin = TransformOrigin(1f, 0.5f)
                        this.rotationZ = atan2(difference.y, difference.x).toDegrees()
                    }
            ) {
                arrow.lineEnd?.invoke()
            }
        }
    }
}

class Line(
    val start: LayoutCoordinatesHolder,
    val startAlignment: Alignment,
    val end: LayoutCoordinatesHolder,
    val endAlignment: Alignment,
    val lineStart: (@Composable () -> Unit)? = null,
    val lineEnd: (@Composable () -> Unit)? = null,
    val drawBody: DrawScope.() -> Unit,
)

sealed interface LineEnd {

    val content: @Composable () -> Unit

    data class Triangle(
        val size: Dp,
        val color: Color,
    ) : LineEnd {
        override val content: @Composable () -> Unit = {
            Canvas(Modifier.size(size)) {
                drawPath(
                    path = Path().apply {
                        val topStart = size.toRect().topStart
                        val centerEnd = size.toRect().centerEnd
                        val bottomStart = size.toRect().bottomStart
                        moveTo(topStart.x, topStart.y)
                        lineTo(centerEnd.x, centerEnd.y)
                        lineTo(bottomStart.x, bottomStart.y)
                        close()
                    },
                    color = color,
                )
            }
        }
    }
}

fun Arrow(
    start: LayoutCoordinatesHolder,
    startAlignment: Alignment,
    end: LayoutCoordinatesHolder,
    endAlignment: Alignment,
    color: Color,
    lineEndSize: Dp = 24.dp,
    head: LineEnd? = LineEnd.Triangle(
        size = lineEndSize,
        color = color,
    ),
    tail: LineEnd? = null,
    lineWidth: Dp = 2.dp,
): Line = Line(
    start = start,
    startAlignment = startAlignment,
    end = end,
    endAlignment = endAlignment,
    lineStart = tail?.content,
    lineEnd = head?.content,
    drawBody = {
        drawLine(
            color = Color.White,
            start = Offset.Zero + if (tail == null) {
                Offset.Zero
            } else {
                Offset(lineEndSize.toPx(), 0f)
            },
            end = size.toRect().centerRight - if (head == null) {
                Offset.Zero
            } else {
                Offset(lineEndSize.toPx(), 0f)
            },
            strokeWidth = lineWidth.toPx(),
        )
    },
)

private fun Float.toDegrees() = this * 180f / PI.toFloat()
