import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.cristina.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "LoginKMP - Desktop",
        state = rememberWindowState(width = 400.dp, height = 600.dp)
    ) {
        App()
    }
}
