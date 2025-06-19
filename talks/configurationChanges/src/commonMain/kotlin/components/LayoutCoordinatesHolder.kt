/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package components

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.node.LayoutAwareModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo

/**
 * A mutable holder of [LayoutCoordinates].
 *
 * A created [LayoutCoordinatesHolder] should be remembered, and passed to exactly one [Modifier.layoutCoordinates]
 * to update its value.
 */
@Stable
class LayoutCoordinatesHolder {
    var coordinates: LayoutCoordinates? by mutableStateOf(null)
        internal set
}

/**
 * Updates a [LayoutCoordinatesHolder] with the coordinates from this node.
 */
fun Modifier.layoutCoordinates(
    holder: LayoutCoordinatesHolder
): Modifier = this then LayoutCoordinatesElement(holder)

private data class LayoutCoordinatesElement(val holder: LayoutCoordinatesHolder) :
    ModifierNodeElement<LayoutCoordinatesNode>() {
    override fun create() = LayoutCoordinatesNode(holder)

    override fun update(node: LayoutCoordinatesNode) {
        node.holder = holder
        node.forceUpdate()
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "layoutCoordinates"
        properties["holder"] = holder
    }
}

internal class LayoutCoordinatesNode(
    var holder: LayoutCoordinatesHolder
) : Modifier.Node(), LayoutAwareModifierNode {
    var lastCoordinates: LayoutCoordinates? = null

    fun forceUpdate() {
        holder.coordinates = lastCoordinates
    }

    override fun onPlaced(coordinates: LayoutCoordinates) {
        lastCoordinates = coordinates
        holder.coordinates = lastCoordinates
    }

    override fun onDetach() {
        holder.coordinates = null
    }
}
