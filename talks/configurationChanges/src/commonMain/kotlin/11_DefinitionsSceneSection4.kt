import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.Arrow
import components.LineCanvas
import components.LayoutCoordinatesHolder
import components.layoutCoordinates
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import theme.jetBrainsMono

@OptIn(ExperimentalSharedTransitionApi::class)
fun StoryboardBuilder.Scene11_DefinitionsScene4() {
    scene(
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        val configChangeLayoutCoordinatesHolder = remember { LayoutCoordinatesHolder() }
        val recreationLayoutCoordinatesHolder = remember { LayoutCoordinatesHolder() }
        val onConfigurationChangedLayoutCoordinatesHolder = remember { LayoutCoordinatesHolder() }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .layoutCoordinates(configChangeLayoutCoordinatesHolder)
                        .padding(16.dp),
                ) {
                    Text(
                        "Configuration",
                        style = MaterialTheme.typography.h4,
                    )
                    Text(
                        "Changes",
                        style = MaterialTheme.typography.h4,
                    )
                }

                Spacer(Modifier.size(100.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        "Activity Recreation",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier
                            .layoutCoordinates(recreationLayoutCoordinatesHolder)
                            .padding(16.dp)
                    )

                    Spacer(Modifier.height(64.dp))

                    Text(
                        "onConfigurationChanged",
                        style = MaterialTheme.typography.h4,
                        fontFamily = jetBrainsMono,
                        modifier = Modifier
                            .layoutCoordinates(onConfigurationChangedLayoutCoordinatesHolder)
                            .padding(horizontal = 16.dp)
                    )
                }
            }

            LineCanvas(
                lines = listOf(
                    Arrow(
                        start = configChangeLayoutCoordinatesHolder,
                        startAlignment = Alignment.CenterEnd,
                        end = recreationLayoutCoordinatesHolder,
                        endAlignment = Alignment.CenterStart,
                        color = MaterialTheme.colors.onSurface,
                    ),
                    Arrow(
                        start = configChangeLayoutCoordinatesHolder,
                        startAlignment = Alignment.CenterEnd,
                        end = onConfigurationChangedLayoutCoordinatesHolder,
                        endAlignment = Alignment.CenterStart,
                        color = MaterialTheme.colors.onSurface,
                    ),
                ),
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
