package com.example.mycompose.case1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview("column")
@Composable
fun ColumnLayout() {
    Column(
        modifier = Modifier
            .background(Color(0xFF063142))
            .padding(16.dp)
            .size(150.dp)
    ) {
        Text(
            text = "", modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFFFFFF00))
        )
        Text(
            text = "", modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true)
                .background(Color(0xFF4385F4))
        )
        Text(
            text = "", modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true)
                .background(Color(0xFF3CDB85))
        )
    }
}

@Preview("row")
@Composable
fun RowLayout() {
    Row(
        modifier = Modifier
            .size(200.dp)
            .background(Color(0xFF063142))
    ) {
        Text(
            text = "", modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color(0xFFFFFF00))
        )
        Text(
            text = "", modifier = Modifier
                .fillMaxHeight()
                .weight(1f, true)
                .background(Color(0xFF4385F4))
        )
        Text(
            text = "", modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color(0xFF3CDB85))
        )
    }
}



@Preview("box")
@Composable
fun BoxLayout() {
    Box(modifier = Modifier.size(200.dp)) {
        Text(
            text = "", modifier = Modifier
                .background(Color(0xFF063142))
                .fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "",
                modifier = Modifier
                    .size(
                        100.dp, 100.dp
                    )
                    .background(Color.Yellow)
            )
        }

    }
}