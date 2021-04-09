package com.example.mycompose.case1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview("ColumnLayout")
@Composable
fun ColumnLayout() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .size(150.dp)
            .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Text1",
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Text2", modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Text(
            text = "Text3", modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
    }
}

@Preview("rowLayout")
@Composable
fun RowLayout() {
    Row(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Blue)
    ) {
        Text(text = "Text1")
        Text(text = "Text2")
        Text(text = "Text3")
    }
}

@Preview("box")
@Composable
fun BoxLayout() {
    Box(modifier = Modifier.size(200.dp)) {
        Text(text = "text1")
        Text(text = "text2")
    }
}