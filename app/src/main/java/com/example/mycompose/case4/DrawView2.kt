package com.example.mycompose.case4

import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
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


@SuppressLint("UnrememberedMutableState")
@Preview("drawView2")
@Composable
fun DrawView2() {

    var pathSave: SnapshotStateList<Pair<Boolean, Pair<Float, Float>>?> = mutableStateListOf(null)

    Box(modifier = Modifier.fillMaxSize()) {

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
                            pathSave.add(Pair(false, Pair(it.x, it.y)))
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

        Text(
            modifier = Modifier
                .padding(20.dp)
                .background(Color(0xFF00ffff), RoundedCornerShape(12.dp))
                .padding(10.dp)
                .clickable {
                    pathSave.retract()
                },
            text = "回撤"
        )
    }

}

private fun SnapshotStateList<Pair<Boolean, Pair<Float, Float>>?>.retract(): SnapshotStateList<Pair<Boolean, Pair<Float, Float>>?> {
    var lastStart = 0;
    forEachIndexed { index, item ->
        if (item != null && item.first) {
            lastStart = index
        }
    }

    if (lastStart != 0) {
        removeRange(lastStart, size)
        removeLast()
    } else {
        clear()
    }
    return this
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


