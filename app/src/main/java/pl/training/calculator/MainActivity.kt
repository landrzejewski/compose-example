package pl.training.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.training.calculator.ui.theme.CalculatorTheme
import pl.training.calculator.ui.theme.defaultFont
import pl.training.calculator.ui.theme.orange

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Calculator(innerPadding)
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 64.dp)
                    ) {
                        Button(onClick = { viewModel.addMessage() }) {
                            Text(
                                text = "Add message"
                            )
                        }
                        /*viewModel.messages.forEach {
                            Text(
                                text = it,
                                color = Color.DarkGray
                            )
                        }*/
                        LazyColumn(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(viewModel.messages) {
                                Text(
                                    text = it,
                                    color = Color.DarkGray
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Calculator(innerPadding: PaddingValues) {
    val rowPadding = 8.dp
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column {
            Display("0")
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowPadding)

            ) {
                CircleButton("AC", Color.Gray, Color.White)
                CircleButton("+/-", Color.Gray, Color.White)
                CircleButton("%", Color.Gray, Color.White)
                CircleButton("/", orange, Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowPadding)
            ) {
                CircleButton("7", Color.DarkGray, Color.White)
                CircleButton("8", Color.DarkGray, Color.White)
                CircleButton("9", Color.DarkGray, Color.White)
                CircleButton("X", orange, Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowPadding)
            ) {
                CircleButton("4", Color.DarkGray, Color.White)
                CircleButton("5", Color.DarkGray, Color.White)
                CircleButton("6", Color.DarkGray, Color.White)
                CircleButton("-", orange, Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowPadding)
            ) {
                CircleButton("1", Color.DarkGray, Color.White)
                CircleButton("2", Color.DarkGray, Color.White)
                CircleButton("3", Color.DarkGray, Color.White)
                CircleButton("+", orange, Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowPadding)
            ) {
                CircleButton("M+", Color.DarkGray, Color.White)
                CircleButton("0", Color.DarkGray, Color.White)
                CircleButton(",", Color.DarkGray, Color.White)
                CircleButton("=", orange, Color.White)
            }
        }
    }
}

@Composable
fun Display(value: String) {
    Text(
        text = value,
        textAlign = TextAlign.End,
        color = Color.Black,
        fontSize = 64.sp,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    )
}

@Composable
fun CircleButton(
    text: String,
    color: Color,
    textColor: Color,
    onTapListener: () -> Unit = {}
) {
    val size = 60.dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(size)
            .height(size)
            .clip(RoundedCornerShape(size))
            .background(color)
            .clickable { onTapListener() }
    ) {
        Text(
            text = text,
            color = textColor,
            style = defaultFont
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
    }
}