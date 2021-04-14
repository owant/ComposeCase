package com.example.mycompose.case4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

class LevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var angleValue by rememberSaveable { mutableStateOf<Float>(65F) }
            Column {
                LevelView(30F, 10, angleValue)
                Text(text = "改变进度", modifier = Modifier.clickable {
                    angleValue += 15
                })
            }
        }
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, LevelActivity::class.java)
            context.startActivity(starter)
        }
    }
}