package com.example.canvaspractice

import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvaspractice.ui.theme.CanvasPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}


@Preview(showBackground = true)
@Composable
 fun DefaultPreview() {
    val animationTargetState = remember { mutableStateOf(230f) }


    val isClicked = remember { mutableStateOf(true) }
    var isAnimated by remember { mutableStateOf(true) }


    val btnColor = remember { Animatable(Color.DarkGray) }
    // animate to green/red based on `button click`
    LaunchedEffect(isAnimated) {
        btnColor.animateTo(if (isAnimated) Color.Black else Color.White, animationSpec = tween(800))
    }


    val animatedFloatState = animateFloatAsState(
        // Whenever the target value changes, new animation
        // will start to the new target value
        targetValue = animationTargetState.value,
        animationSpec = tween(durationMillis = 800)
    )


    val textPaintLight = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        textSize = 60F
        color = android.graphics.Color.BLACK
        typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
    }
    val textPaintDark = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        textSize = 60F
        color = android.graphics.Color.WHITE
        typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
    }




        Canvas(modifier = Modifier
            .size(size = 300.dp)
            .background(Color.Gray)

            .clickable {
                isAnimated = !isAnimated
                if (isClicked.value) {
                    animationTargetState.value = 592f
                    isClicked.value = false

                } else {

                    animationTargetState.value = 234f
                    isClicked.value = true


                }
            }
        ){



            drawRoundRect(
                color = btnColor.value,
                size = Size(width = 220.dp.toPx(), height = 90.dp.toPx()),
                cornerRadius = CornerRadius(x = 44.dp.toPx(), 44.dp.toPx()),
                topLeft = Offset(x = 40.dp.toPx(), y = 110.dp.toPx()),
            )


            drawRoundRect(
                color = Color.Gray,
                size = Size(width = 220.dp.toPx(), height = 90.dp.toPx()),
                cornerRadius = CornerRadius(x = 44.dp.toPx(), 44.dp.toPx()),
                topLeft = Offset(x = 40.dp.toPx(), y = 110.dp.toPx()),
                style = Stroke(width = 26.dp.toPx())
            )

            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    "Dark",
                    190f,            // x-coordinates of the origin (top left)
                    161.dp.toPx(), // y-coordinates of the origin (top left)
                    textPaintDark
                )
            }
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    "Light",
                    460f,            // x-coordinates of the origin (top left)
                    161.dp.toPx(), // y-coordinates of the origin (top left)
                    textPaintLight
                )
            }

            drawCircle(
                brush = Brush.horizontalGradient(startX = animatedFloatState.value-100f, endX = animatedFloatState.value+100f, colors = listOf(Color(
                    0xFF646464
                ), Color(0xFF252525)
                )),
                radius = 24.dp.toPx(),
                center = Offset(x = animatedFloatState.value, y = 154.dp.toPx()),
            )


            drawRoundRect(
                brush = Brush.horizontalGradient(colors = listOf(Color(0xFF494949),Color(0xFF292929))),
                size = Size(width = 200.dp.toPx(), height = 68.dp.toPx()),
                cornerRadius = CornerRadius(x = 44.dp.toPx(), 44.dp.toPx()),
                topLeft = Offset(x = 50.dp.toPx(), y = 120.dp.toPx()),
                style = Stroke(width = 10.dp.toPx())
            )
        }



}
















