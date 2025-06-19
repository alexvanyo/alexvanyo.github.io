package components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect

context(drawScope: DrawScope)
val Rect.topStart get(): Offset = topStart(drawScope.layoutDirection)

context(drawScope: DrawScope)
val Rect.topEnd get(): Offset = topEnd(drawScope.layoutDirection)

context(drawScope: DrawScope)
val Rect.centerStart get(): Offset = centerStart(drawScope.layoutDirection)

context(drawScope: DrawScope)
val Rect.centerEnd get(): Offset = centerEnd(drawScope.layoutDirection)

context(drawScope: DrawScope)
val Rect.bottomStart get(): Offset = bottomStart(drawScope.layoutDirection)

context(drawScope: DrawScope)
val Rect.bottomEnd get(): Offset = bottomEnd(drawScope.layoutDirection)

context(drawScope: DrawScope)
val IntRect.topStart get(): IntOffset = topStart(drawScope.layoutDirection)

context(drawScope: DrawScope)
val IntRect.topEnd get(): IntOffset = topEnd(drawScope.layoutDirection)

context(drawScope: DrawScope)
val IntRect.centerStart get(): IntOffset = centerStart(drawScope.layoutDirection)

context(drawScope: DrawScope)
val IntRect.centerEnd get(): IntOffset = centerEnd(drawScope.layoutDirection)

context(drawScope: DrawScope)
val IntRect.bottomStart get(): IntOffset = bottomStart(drawScope.layoutDirection)

context(drawScope: DrawScope)
val IntRect.bottomEnd get(): IntOffset = bottomEnd(drawScope.layoutDirection)
