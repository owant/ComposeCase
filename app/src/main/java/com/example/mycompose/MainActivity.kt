package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycompose.case4.DrawActivity
import com.example.mycompose.case4.LevelActivity
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(name = "Compose", onClick = {
                when (it) {
                    "tag1" -> {
                        DrawActivity.start(this)
                    }
                    "tag2" -> {
                        LevelActivity.start(this)
                    }
                    else -> {

                    }

                }
            })
        }

    }
}

@Composable
fun Greeting(name: String, onClick: (tag: String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $name!", modifier = Modifier.clickable {
            onClick("tag1")
        })
        Text(text = "Hello $name!", modifier = Modifier.clickable {
            onClick("tag2")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        Greeting("Android", onClick = {})
    }
}