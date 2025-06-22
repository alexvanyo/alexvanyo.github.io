package theme

import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_Bold
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_BoldItalic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_ExtraBold
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_ExtraBoldItalic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_ExtraLight
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_ExtraLightItalic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_Italic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_Light
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_LightItalic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_Medium
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_MediumItalic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_Regular
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_SemiBold
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_SemiBoldItalic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_Thin
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.JetBrainsMono_ThinItalic
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.NotoColorEmoji
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.Res
import alex.vanyo.dev.talks.configurationchanges.configurationchanges.generated.resources.RobotoFlex
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font

val colors = darkColors(
    background = Color.Black,
    primary = Color(0xffffff9d),
    secondary = Color(0xffb1c8e9),
)

val typography
    @Composable
    get() = Typography(
        defaultFontFamily = FontFamily(
            Font(
                resource = Res.font.RobotoFlex,
            )
        )
    )

@Composable
fun TalkTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = colors,
        typography = typography,
    ) {
        content()
    }
}

val notoColorEmoji
    @Composable
    get() = FontFamily(Font(Res.font.NotoColorEmoji))

val jetBrainsMono
    @Composable
    get() = FontFamily(
        Font(
            resource = Res.font.JetBrainsMono_Thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_ThinItalic,
            weight = FontWeight.Thin,
            style = FontStyle.Italic
        ),

        Font(
            resource = Res.font.JetBrainsMono_ExtraLight,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_ExtraLightItalic,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Italic
        ),

        Font(
            resource = Res.font.JetBrainsMono_Light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_LightItalic,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),

        Font(
            resource = Res.font.JetBrainsMono_Regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_Italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),

        Font(
            resource = Res.font.JetBrainsMono_Medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_MediumItalic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic
        ),

        Font(
            resource = Res.font.JetBrainsMono_SemiBold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_SemiBoldItalic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic
        ),

        Font(
            resource = Res.font.JetBrainsMono_Bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_BoldItalic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),

        Font(
            resource = Res.font.JetBrainsMono_ExtraBold,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_ExtraBoldItalic,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Italic
        ),
    )
