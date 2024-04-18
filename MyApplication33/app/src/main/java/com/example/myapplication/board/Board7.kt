package com.example.myapplication.board
import android.graphics.Rect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R

import androidx.compose.runtime.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*

import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Paint

@Composable
//@Preview
fun Board7() {
    var isPasswordEntered by remember { mutableStateOf(false) }
    var password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Пропустить", fontSize = 20.sp, color = Color(0xFF57A9FF),
                modifier = Modifier.padding(top = 30.dp, bottom = 20.dp, start = 255.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Создайте пароль", fontSize = 35.sp, color = Color(0xFF000000)
            )
            Text(
                text = "Для защиты ваших персональных данных",
                fontSize = 14.sp,
                color = Color(0xFF939396),
                modifier = Modifier.padding(top = 33.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))

            Box(
                modifier = Modifier.background(color = Color.Transparent)
            ) {

                Canvas(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    drawCircle(
                        style = Stroke(3f),
                        color = Color(0xFF57A9FF),
                        radius = 30f,
                        center = Offset(350f, 1f)
                    )
                    drawCircle(color = Color(0xFF57A9FF), radius = 30f, center = Offset(450f, 1f))
                    drawCircle(
                        style = Stroke(3f),
                        color = Color(0xFF57A9FF),
                        radius = 30f,
                        center = Offset(550f, 1f)
                    )
                    drawCircle(
                        style = Stroke(3f),
                        color = Color(0xFF57A9FF),
                        radius = 30f,
                        center = Offset(650f, 1f)
                    )

                    val circleRadius = 90f
                    val circleSpacing = 100f
                    val startX = size.width / 2 - (circleRadius * 2 + circleSpacing)
                    val startY = 20f

                    val buttonColor = if (isPasswordEntered) Color.Blue else Color.White

                    val buttons = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

                    buttons.forEachIndexed { index, label ->
                        val row = index / 3
                        val col = index % 3
                        val x = startX + col * (circleRadius * 2 + circleSpacing)
                        val y = startY + (row + 1) * (circleRadius * 2 + circleSpacing)

                        val circleColor = if (isPasswordEntered && label == password.value) Color.Blue else Color(0xFF57A9FF)

                        drawCircle(
                            color = circleColor,
                            radius = circleRadius,
                            center = Offset(x, y)
                        )
                        drawIntoCanvas { canvas ->
                            val paint = Paint().asFrameworkPaint()
                            paint.textSize = 40f

                            val textBounds = Rect()
                            paint.getTextBounds(label, 0, label.length, textBounds)
                            val textWidth = paint.measureText(label)
                            canvas.nativeCanvas.drawText(label, x - textWidth / 2, y + textBounds.height() / 2, paint)
                        }
                    }
                }
            }
        }
    }
}