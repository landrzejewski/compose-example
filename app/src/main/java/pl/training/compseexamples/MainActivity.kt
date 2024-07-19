package pl.training.compseexamples

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {

    val viewModel: Model by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Calculator()
            Messages(viewModel)
        }
    }

}

@Composable
fun Messages(viewModel: Model) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { viewModel.addMessage() }) {
            Text(
                text = "Add",
                fontSize = 18.sp
            )
        }
       /*
       viewModel.messages
        .forEach {
            Text(
                text = it,
                fontSize = 18.sp,
                color = Color.Blue
            )
       }
       */
       LazyColumn {
           items(viewModel.messages) {
               Text(
                   text = it,
                   fontSize = 18.sp,
                   color = Color.Blue
               )
           }
       }
    }
}

@Composable
fun Calculator() {
    val buttonSpacing = 8.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(padding),
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Display("0")
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(padding)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        text = "AC",
                        color = Color.LightGray
                    )
                    CalculatorButton(
                        text = "Del",
                        color = Color.LightGray
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        text = "7",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "8",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "9",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "x",
                        color = orange
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        text = "4",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "5",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "6",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "/",
                        color = orange
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        text = "1",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "2",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "3",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "+",
                        color = orange
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        text = "0",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = ".",
                        color = mediumGrey
                    )
                    CalculatorButton(
                        text = "=",
                        color = orange
                    )
                    CalculatorButton(
                        text = "-",
                        color = orange
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onTapListener: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(60.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(color)
            .clickable { onTapListener() }
            .then(modifier)
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
        )
    }
}

@Composable
fun Display(value: String) {
    Text(
        text = value,
        textAlign = TextAlign.End,
        color = Color.White,
        fontSize = bigFont,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    Messages(viewModel = Model())
}