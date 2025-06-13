import androidx.compose.material.Text
import androidx.compose.ui.text.AnnotatedString
import dev.bnorm.storyboard.StoryboardBuilder
import dev.bnorm.storyboard.easel.template.section
import templates.HeaderBodySceneTemplate

fun StoryboardBuilder.Scene03_DefinitionsSceneSection() {
    section("Definitions") {
        HeaderBodySceneTemplate(
            header = AnnotatedString("What are configuration changes?"),
        ) {
        }
        HeaderBodySceneTemplate(
            header = AnnotatedString("Configuration"),
        ) {
            Text("Configuration _as represented by the Configuration.java_ object")
        }
        HeaderBodySceneTemplate(
            header = AnnotatedString("Changes"),
        ) {
            Text("")
        }
        HeaderBodySceneTemplate(
            header = AnnotatedString("Activity recreation"),
        ) {
            Text("Configuration changes are important because of Activity recreation")
        }
        HeaderBodySceneTemplate(
            header = AnnotatedString("Configuration changes != Activity recreation"),
        ) {

        }
    }
}
