package com.example.mycompose.case4

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview("drawView2")
@Composable
fun DrawView2() {

    val pathSave: SnapshotStateList<Pair<Boolean, Pair<Float, Float>>?> = mutableStateListOf(null)
    var currentPoint: Pair<Boolean, Pair<Float, Float>>? = null

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        pathSave.add(Pair(true, Pair(it.x, it.y)))
                    }
                    MotionEvent.ACTION_MOVE -> {
                        pathSave.add(Pair(false, Pair(it.x, it.y)))
                    }
                    MotionEvent.ACTION_UP -> {
                        currentPoint?.let { _ -> pathSave.add(Pair(false, Pair(it.x, it.y))) }
                        currentPoint = null
                    }
                    else -> false
                }
                true
            }
    ) {
         drawPath(
            path = pathSave.toPath(),
            color = Color.Yellow,
            alpha = 1f,
            style = Stroke(4.dp.toPx())
        )
    }
}

fun SnapshotStateList<Pair<Boolean, Pair<Float, Float>>?>.toPath(): Path {
    val path = Path()
    forEach {
        if (it != null) {
            if (it.first) {
                path.moveTo(it.second.first, it.second.second)
            } else {
                path.lineTo(it.second.first, it.second.second)
            }
        }
    }
    return path
}


