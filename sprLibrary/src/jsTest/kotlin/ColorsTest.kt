import androidx.compose.ui.graphics.Color
import org.compose.shapeshifter.library.toKobweb
import org.jetbrains.compose.web.css.rgb
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorsTest {
    @Test
    fun testJsConversion() {
        val color = Color.Red.toKobweb()
        println("Initial color: ${Color.Red.red}, ${Color.Red.green}, ${Color.Red.blue}, ${Color.Red.alpha}")
        assertEquals(rgb(255, 0, 0), color)
    }
}