import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.swing.text.StyledEditorKit.FontSizeAction

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
            item { RatingRowView() }
            item { PriseView() }
        }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
@Composable
fun PriseView(){

 val isAddedToCarts = remember { mutableStateOf(0) }

    Row(modifier = Modifier.height(80.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,) {
     Text("13 000,00", modifier = Modifier.padding(start = 16.dp))
     Text("₽/шт", modifier = Modifier.weight(1f).padding(start = 4.dp))
//        Spacer(modifier = Modifier.fillMaxSize())
        if (isAddedToCarts.value == 0){
     Button(onClick = {
        isAddedToCarts.value++
     }, modifier = Modifier.background(color = Color(0xFF53c43f), shape = RoundedCornerShape(4.dp)
     ).height(48.dp).width(160.dp)
     ){
         Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
             Text("В корзину", style = TextStyle(color = Color.White), fontWeight = FontWeight.Medium, fontSize = 16.sp  )
         }
     }
        }
        else{
            Text("Кол-во "+ isAddedToCarts.value, modifier = Modifier.height(48.dp).weight(160f))
        }
 }
}

fun addToCart(){

}

@Composable
fun RatingRowView(){
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