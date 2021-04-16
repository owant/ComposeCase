package com.example.mycompose.case1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.R
import com.example.mycompose.ui.base.CenterPreview


@ExperimentalAnimationApi
@Preview
@Composable
fun JetpackCompose() {

    var expended by remember { mutableStateOf(false) }

    Column(
        modifier =
        Modifier
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(30.dp))
            .clickable {
                expended = !expended
            }
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_compose_icon),
            contentDescription = "icon",
            modifier = Modifier.size(250.dp, 250.dp)
        )
        AnimatedVisibility(visible = expended) {
            Text(
                text = "Jetpack Compose",
                modifier = Modifier.padding(6.dp),
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun JetpackTest() {
    CenterPreview {
        JetpackCompose()
    }
}