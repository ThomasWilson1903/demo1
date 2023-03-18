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

val brownGrayColor = Color(0xFF959595)

@Composable
@Preview
fun App() {
    /*Column(modifier = Modifier.fillMaxSize()) {

    }*/
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { Toolbar() }
        item { ImageHeader() }
        item {
            Text(
                "Артикул из класса", modifier = Modifier.padding(top = 24.dp, start = 16.dp),
                style = TextStyle(
                    color = brownGrayColor,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )
        }
        item {
            Text(
                "Названия товара", modifier = Modifier.padding(top = 4.dp, start = 16.dp, end = 24.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            )
        }
        item { RatingRowView() }
        item { PriseView() }
        item { CountView() }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
fun PriseView() {

    val isAddedToCarts = remember { mutableStateOf(0) }

    Row(modifier = Modifier.height(80.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            "13 686,00 ", modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Medium)
        )
        Text(
            "₽/шт", modifier = Modifier.weight(1f).padding(start = 4.dp), style = TextStyle(
                color = brownGrayColor, fontSize = 12.sp
            )
        )
//        Spacer(modifier = Modifier.fillMaxSize())
        if (isAddedToCarts.value == 0) {
            Button(
                onClick = {
                    isAddedToCarts.value++
                }, modifier = Modifier
                    .background(
                        color = brownGrayColor,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .height(48.dp)
                    .width(160.dp)
                    .padding(end = 24.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(
                        "В корзину",
                        style = TextStyle(color = Color.White),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height(48.dp).width(160.dp).padding(end = 24.dp)
            ) {
                Text("Кол-во" + isAddedToCarts.value)
            }
        }
    }
}

fun addToCart() {

}

@Composable
fun CountView() {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
    ){
        Box(
            Modifier.background(color = brownGrayColor).padding(start = 16.dp).size(24.dp)
        )
        Column(
            modifier = Modifier.weight(1f).padding(start = 24.dp, end = 24.dp)
        ) {
            Text("Расчитать количество",style = TextStyle(color = Color.Black))
            Text("В наличии: ${12}", style = TextStyle(color = brownGrayColor, fontSize = 12.sp))
        }

        Box(
            Modifier.background(color = brownGrayColor).padding(end = 16.dp).size(24.dp)
        )
    }
}

@Composable
fun RatingRowView() {
    Box(modifier = Modifier.background(color = Color.Gray).height(52.dp).fillMaxWidth())
}

@Composable
fun ImageHeader() {
    Box(modifier = Modifier.background(color = Color.Gray).height(300.dp).fillMaxWidth())
}

@Composable
fun Toolbar() {
    Row(modifier = Modifier.height(44.dp).fillMaxWidth().background(color = MaterialTheme.colors.background)) {
        Text("Bace")
        Text("Menu")
    }


}