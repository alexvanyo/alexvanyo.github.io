package com.alexvanyo.website.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.Router
import com.arkivanov.decompose.RouterState
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.lifecycle
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arkivanov.decompose.pop
import com.arkivanov.decompose.push
import com.arkivanov.decompose.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.browser.window
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.get
import org.w3c.dom.set

@Composable
fun BackstackPage() {
    val lifecycle = lifecycle()
    val component = remember {
        RootComponent(
            DefaultComponentContext(
                lifecycle = lifecycle,
                stateKeeper = null,
                instanceKeeper = null,
                backPressedDispatcher = null
            )
        )
    }

    BackstackScreen(component)
}

interface Root {
    val routerState: Value<RouterState<*, Child>>

    fun navigateBack()

    fun navigateForward()

    data class Child(
        val counter: Counter,
    )
}

class RootComponent(
    componentContext: ComponentContext,
) : Root, ComponentContext by componentContext {
    private val router: Router<ChildConfiguration, Root.Child> = router(
        initialConfiguration = ChildConfiguration(
            index = 0,
        ),
        handleBackButton = true,
    ) { configuration, componentContext ->
        Root.Child(CounterComponent(componentContext, configuration.isBackEnabled, configuration.index))
    }

    override val routerState: Value<RouterState<*, Root.Child>> = router.state

    override fun navigateBack() {
        router.pop()
    }

    override fun navigateForward() {
        router.push(ChildConfiguration(router.state.value.backStack.size + 1))
    }

    private data class ChildConfiguration(
        val index: Int,
    ) : Parcelable {
        val isBackEnabled = index > 0
    }
}

interface Counter {
    val isBackEnabled: Boolean
    val index: Int
    var count: Int
}

class CounterComponent(
    componentContext: ComponentContext,
    override val isBackEnabled: Boolean,
    override val index: Int,
) : Counter, ComponentContext by componentContext {

    private val restoredState: Model? =
        window.sessionStorage["STATE_KEY_$index"]?.toInt()?.let(::Model) // stateKeeper.consume("STATE")

    override var count: Int by mutableStateOf(restoredState?.count ?: 0)

    init {
        stateKeeper.register("STATE") {
            window.sessionStorage["STATE_KEY_$index"] = count.toString()
            Model(count)
        }
    }

    data class Model(
        val count: Int
    ) : Parcelable
}

@Composable
fun BackstackScreen(
    root: Root,
) {
    val state by root.routerState.subscribeAsState()
    val child = state.activeChild

    CounterScreen(
        child.instance.counter,
        root::navigateBack,
        root::navigateForward,
    )
}

@Composable
fun CounterScreen(
    counter: Counter,
    onBackClicked: () -> Unit,
    onForwardClicked: () -> Unit,
) {
    Div({
        style { padding(25.px) }
    }) {
        if (counter.isBackEnabled) {
            Button({
                onClick { onBackClicked() }
            }) {
                Text("Back")
            }
        }

        Span({
            style { padding(15.px) }
        }) {
            Text("id: ${counter.index}")
        }

        Button({
            onClick { counter.count-- }
        }) {
            Text("-")
        }

        Span({
            style { padding(15.px) }
        }) {
            Text("${counter.count}")
        }

        Button({
            onClick { counter.count++ }
        }) {
            Text("+")
        }

        Button({
            onClick { onForwardClicked() }
        }) {
            Text("Forward")
        }
    }
}
