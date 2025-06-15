package components

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.visible(visible: Boolean) = if (visible) this else this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {}
}
