package com.arkivanov.decompose.extensions.compose.jetbrains

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.RouterState
import com.arkivanov.decompose.value.Value

typealias ChildContent<C, T> = @Composable (child: Child.Created<C, T>) -> Unit

typealias ChildAnimation<C, T> = @Composable (RouterState<C, T>, ChildContent<C, T>) -> Unit

@Composable
fun <C : Any, T : Any> Children(
    routerState: RouterState<C, T>,
    animation: ChildAnimation<C, T> = { state, childContent -> childContent(state.activeChild) },
    content: ChildContent<C, T>
) {

    animation(routerState) { child ->
        //holder.SaveableStateProvider(child.configuration) {
            content(child)
        //}
    }
}

@Composable
fun <C : Any, T : Any> Children(
    routerState: Value<RouterState<C, T>>,
    animation: ChildAnimation<C, T> = { state, childContent -> childContent(state.activeChild) },
    content: ChildContent<C, T>
) {
    val state = routerState.subscribeAsState()

    Children(
        routerState = state.value,
        animation = animation,
        content = content
    )
}

