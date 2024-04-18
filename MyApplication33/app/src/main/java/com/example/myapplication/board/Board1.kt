package com.example.myapplication.board



import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R

import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun Start(navController: NavHostController) {
    Box(

        modifier = Modifier.fillMaxSize(1f).background(
            Brush.linearGradient(
                colors = listOf(
                    Color(161, 202, 255),
                    Color(77, 156, 255),
                    Color(161, 202, 255)
                ),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(Float.POSITIVE_INFINITY, 0f)
            )
        )
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(116, 200, 228),
                        Color(115, 213, 188),
                        Color(116, 200, 228)
                    )
                )
            )
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(98, 105, 240).copy(alpha = 0.05f),
                        Color(55, 64, 245).copy(alpha = 0.65f),
                        Color(34, 84, 245).copy(alpha = 1f),
                        Color(55, 64, 245,).copy(alpha = 0.65f),
                        Color(98, 105, 240,).copy(alpha = 0.05f)
                    )
                )
            )
    )

    {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextButton(onClick = { navController.navigate("Board2") }) {

                    }

                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.width(263.dp)
                        )
                    }
                }
            }
        }
    }


