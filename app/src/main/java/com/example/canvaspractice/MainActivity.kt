package com.example.canvaspractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.canvaspractice.ui.theme.CanvasPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val animationTargetState = remember { mutableStateOf(230f) }
    val isClicked = remember { mutableStateOf(false) }

    val animatedFloatState = animateFloatAsState(
        // Whenever the target value changes, new animation
        // will start to the new target value
        targetValue = animationTargetState.value,
        animationSpec = tween(durationMillis = 800)
    )


    Canvas(modifier = Modifier
        .size(size = 300.dp)
        .background(Color.Gray)

        .clickable {
            if (isClicked.value){
                animationTargetState.value = 592f
                isClicked.value = false
            }else{
                animationTargetState.value = 234f
                isClicked.value = true
            }
        }
        ){

        drawCircle(
            color = Color.White,
            radius = 46.dp.toPx(),
            center = Offset(x = animatedFloatState.value, y = 154.dp.toPx()),
            alpha = 0.2f
        )
        drawCircle(
            color = Color.White,
            radius = 36.dp.toPx(),
            center = Offset(x = animatedFloatState.value, y = 154.dp.toPx()),
            alpha = 0.4f
        )
        drawRoundRect(
            color = Color.Gray,
            size = Size(width = 220.dp.toPx(), height = 90.dp.toPx()),
            cornerRadius = CornerRadius(x = 44.dp.toPx(), 44.dp.toPx()),
            topLeft = Offset(x = 40.dp.toPx(), y = 110.dp.toPx()),
            style = Stroke(width = 26.dp.toPx())
        )
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
















