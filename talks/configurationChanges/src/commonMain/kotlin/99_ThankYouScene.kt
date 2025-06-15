import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.Res
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.qr_code
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.SceneEnter
import dev.bnorm.storyboard.easel.template.SceneExit
import org.jetbrains.compose.resources.painterResource

fun StoryboardBuilder.Scene99_ThankYouScene() {
    scene(
        enterTransition = SceneEnter(Alignment.CenterEnd),
        exitTransition = SceneExit(Alignment.CenterEnd),
    ) {
        Box(Modifier.padding(32.dp).fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    AnnotatedString("Thank you!"),
                    style = MaterialTheme.typography.h2,
                )
                Spacer(Modifier.height(24.dp))
                Text(
                    buildAnnotatedString {
                        append("Built with ")
                        withLink(
                            LinkAnnotation.Url("https://github.com/bnorm/storyboard")
                        ) {
                            append("github.com/bnorm/storyboard")
                        }
                    },
                    style = MaterialTheme.typography.h4,
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(Res.drawable.qr_code),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(RoundedCornerShape(8.dp)),
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    buildAnnotatedString {
                        withLink(
                            LinkAnnotation.Url("https://alex.vanyo.dev/talks/configurationchanges"),
                        ) { append("alex.vanyo.dev/talks/configurationchanges") }
                    },
                )
                Text(
                    buildAnnotatedString {
                        withLink(
                            LinkAnnotation.Url("https://bsky.app/profile/vanyo.dev"),
                        ) { append("bsky.app/profile/vanyo.dev") }
                    },
                )
            }
        }
    }
}