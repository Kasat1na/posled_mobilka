package com.example.myapplication.board
import android.graphics.Rect
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.border

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue





fun ValidationEmai(pole: String): Boolean {
    val emailRegex = Regex("")
    return emailRegex.matches(pole)
}
//@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Board8() {
    var pole by remember { mutableStateOf(TextFieldValue()) }
    var textState by remember { mutableStateOf(false) }
    var knopColor by remember { mutableStateOf(Color(0xFFC9D4FB)) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFffffff))
            .padding(horizontal = 20.dp)

    )
    {
            Text(
                "Создание карты пациента",
                fontSize = 31.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 50.dp)

            )
            Text(
                text = "Пропустить", fontSize = 20.sp, color = Color(0xFF57A9FF),
                modifier = Modifier.padding(top = 20.dp, bottom = 50.dp, start = 240.dp)
            )

            Text(
                text = "Без карты пациента вы не сможете заказать анализы. ",
                fontSize = 15.sp,
                color = Color(0xFF939396)

            )
            Text(
                text = "В картах пациентов будут храниться рузельтаты анализов вас и ваших близких.",
                fontSize = 15.sp,
                color = Color(0xFF939396)

            )
            OutlinedTextField(
                value = pole,
                onValueChange = {
                    pole = it
                    textState = ValidationEmai(it.text)
                    knopColor = if (textState) Color(0xFF1A6FEE) else Color(0xFFC9D4FB)
                },
                modifier = Modifier
                    .width(335.dp)
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF5F5F9),
                    focusedTextColor = Color(0XFF939396),
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "Имя",
                        fontSize = 15.sp,
                        color = Color(0XFF939396)
                    )
                }
            )
            OutlinedTextField(
                value = pole,
                onValueChange = {
                    pole = it
                    textState = ValidationEmai(it.text)
                    knopColor = if (textState) Color(0xFF1A6FEE) else Color(0xFFC9D4FB)
                },
                modifier = Modifier
                    .width(335.dp)
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF5F5F9),
                    focusedTextColor = Color(0XFF939396),
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "Отчество",
                        fontSize = 15.sp,
                        color = Color(0XFF939396)
                    )
                }
            )
            OutlinedTextField(
                value = pole,
                onValueChange = {
                    pole = it
                    textState = ValidationEmai(it.text)
                    knopColor = if (textState) Color(0xFF1A6FEE) else Color(0xFFC9D4FB)
                },
                modifier = Modifier
                    .width(335.dp)
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF5F5F9),
                    focusedTextColor = Color(0XFF939396),
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "Фамилия",
                        fontSize = 15.sp,
                        color = Color(0XFF939396)
                    )
                }
            )
            OutlinedTextField(
                value = pole,
                onValueChange = {
                    pole = it
                    textState = ValidationEmai(it.text)
                    knopColor = if (textState) Color(0xFF1A6FEE) else Color(0xFFC9D4FB)
                },
                modifier = Modifier
                    .width(335.dp)
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF5F5F9),
                    focusedTextColor = Color(0XFF939396),
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "Дата рождения",
                        fontSize = 15.sp,
                        color = Color(0XFF939396)
                    )
                }
            )
            OutlinedTextField(
                value = pole,
                onValueChange = {
                    pole = it
                    textState = ValidationEmai(it.text)
                    knopColor = if (textState) Color(0xFF1A6FEE) else Color(0xFFC9D4FB)
                },
                modifier = Modifier
                    .width(335.dp)
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF5F5F9),
                    focusedTextColor = Color(0XFF939396),
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "Пол",
                        fontSize = 15.sp,
                        color = Color(0XFF939396)
                    )
                }
            )

            Button(
                onClick = {
                    if (textState) {/*navController.navigate("Board6")*/
                    }
                },
                modifier = Modifier
                    .padding(top = 26.dp)
                    .width(335.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = knopColor,
                    contentColor = Color.White
                ),
            )
            {
                Text(text = "Создать", fontSize = 20.sp, color = Color(0xFFffffff))
            }
        }
    }





