import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.swing.text.Style

@Composable
@Preview
fun App() {
        /*Column(modifier = Modifier.fillMaxSize()) {

        }*/
        LazyColumn(modifier = Modifier.fillMaxSize()){
            item {Toolbar()}
            item {ImageHeader()}
            item { Text("Артикул из класса", modifier = Modifier.padding(top=24.dp, start = 16.dp,),
                style = TextStyle(color =  Color(0xFF959595)),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            ) }
            item { Text("Названия товара", modifier = Modifier.padding(top = 4.dp, start = 16.dp, end = 24.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
            ))
            }
            item { RatingRow() }
        }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
@Composable
fun RatingRow(){
    Box(modifier = Modifier.background(color = Color.Gray).height(52.dp).fillMaxWidth())
}

@Composable
fun ImageHeader(){
    Box(modifier = Modifier.background(color = Color.Gray).height(300.dp).fillMaxWidth())
}

@Composable
fun Toolbar(){
    Row(modifier = Modifier.height(44.dp).fillMaxWidth().background(color = MaterialTheme.colors.background)) {
        Text("Bace")
        Text("Menu")
    }


}