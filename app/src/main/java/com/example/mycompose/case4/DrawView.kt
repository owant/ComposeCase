package com.example.mycompose.case4

import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@SuppressLint("UnrememberedMutableState")
@Preview("drawView")
@Composable
fun DrawView() {

    val action = mutableStateOf<Pair<Float, Float>>(Pair(0F, 0F))
    val pathSave = mutableStateListOf<Path>()
    var currentPath: Path? = null

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        currentPath = Path()
                        currentPath?.moveTo(it.x, it.y)
                        action.value = Pair(it.x, it.y)
                    }
                    MotionEvent.ACTION_MOVE -> {
                        currentPath?.lineTo(it.x, it.y)
                        action.value = Pair(it.x, it.y)
                    }
                    MotionEvent.ACTION_UP -> {
                        currentPath?.let { it1 -> pathSave.add(it1) }
                        currentPath = null
                        action.value = Pair(it.x, it.y)
                    }
                    else -> false
                }
                true
            }
    ) {
        action.value.let {
            currentPath?.let {
                pathSave.add(it)
            }

            pathSave.forEach { p ->
                drawPath(
                    path = p,
                    color = Color.Yellow,
                    alpha = 1f,
                    style = Stroke(4.dp.toPx())
                )
            }
        }
    }
}

