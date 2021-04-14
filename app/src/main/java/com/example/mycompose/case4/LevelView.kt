package com.example.mycompose.case4

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview("levelView")
@Composable
fun LevelView(singleAngle: Float = 30F, levelSize: Int = 8, angleValue: Float = 45F) {

    val size = 300.dp
    val lineSize = 20.dp

    //计算出旋转的角度
    val ration = ration(levelSize * singleAngle)
    val slipSize = 360 / singleAngle / 2
    val slipWidth = 5.dp

    Canvas(
        modifier = Modifier
            .size(size)
    ) {
        drawIntoCanvas { canvas ->
            val lineWidth = lineSize.toPx()
            rotate(ration, center) {

                canvas.saveLayer(
                    Rect(
                        Offset.Zero,
                        Size(size.toPx(), size.toPx())
                    ),
                    Paint()
                )

                drawArc(
                    color = Color.Yellow,
                    startAngle = 0F, sweepAngle = levelSize * singleAngle,
                    useCenter = false,
                    topLeft = Offset(lineWidth / 2, lineWidth / 2),
                    size = Size(
                        size.toPx() - lineWidth,
                        size.toPx() - lineWidth,
                    ),
                    alpha = 1.0f,
                    style = Stroke(lineWidth),
                )

                drawArc(
                    color = Color.Red,
                    startAngle = 0F, sweepAngle = angleValue,
                    useCenter = false,
                    topLeft = Offset(lineWidth / 2, lineWidth / 2),
                    size = Size(
                        size.toPx() - lineWidth,
                        size.toPx() - lineWidth,
                    ),
                    alpha = 1.0f,
                    style = Stroke(lineWidth),
                )

                //划线
                for (index in 0..slipSize.toInt()) {
                    rotate(index * singleAngle, center) {
                        drawLine(
                            Color.Yellow,
                            Offset(0f, size.toPx() / 2),
                            Offset(size.toPx(), size.toPx() / 2),
                            slipWidth.toPx(),
                            blendMode = BlendMode.DstOut
                        )
                    }
                }

                canvas.restore()
            }
        }
    }


}

fun ration(maxAngle: Float): Float {
    return if (maxAngle <= 90f) {
        270F - (maxAngle / 2)
    } else if (maxAngle > 90F && maxAngle <= 180F) {
        180F - (maxAngle / 2)
    } else if (maxAngle > 180F && maxAngle <= 270F) {
        180F - (maxAngle + 180 - 360) / 2
    } else {
        90F + (450F - (maxAngle + 90)) / 2
    }
}



