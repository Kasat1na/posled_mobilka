package com.example.myapplication.board

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


fun ValidationEmail(email: String): Boolean {
    val emailRegex = Regex("^\\S+@\\S+\\.\\S+\$")
    return emailRegex.matches(email)
}
//@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun Board5(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var textState  by remember { mutableStateOf(false) }
    var knopColor by remember { mutableStateOf(Color(0xFFC9D4FB)) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFffffff))
            .padding(horizontal = 20.dp)

    )
    {

        Text(
            "🖐 Добро пожаловать!",
            fontSize = 31.sp,
            color = Color(0xFF000000),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 103.dp)
        )

        Text(
            "Войдите, чтобы пользоваться функциями приложения",
            fontSize = 18.sp,
            color = Color(0xFF000000),
            modifier = Modifier
                .padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Вход по E-mail",
            fontSize = 14.sp,
            color = Color(0xFF7E7E9A),
            modifier = Modifier.padding(bottom = 6.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it
                textState = ValidationEmail(it.text)
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
                    text = "Enter email",
                    fontSize = 15.sp,
                    color = Color(0XFF939396)
                )
            }
        )

        Button(
            onClick = {
                if(textState) {navController.navigate("Board6")}
            },
            modifier = Modifier
                .padding(top = 26.dp)
                .width(335.dp)
                .height(56.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = knopColor,
                contentColor = Color.White),
        )
        {
            Text(text = "Далее", fontSize = 20.sp, color = Color(0xFFffffff))

        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                "Или войдите с помощью",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 80.dp, 0.dp, 15.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color(0xFF939396)
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 56.dp)

                    .fillMaxWidth(1f)
                    .height(55.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFffffff)),
                border = BorderStroke(
                    1.dp, color = Color(0xFFEBEBEB)
                )
            ) {
                Text(
                    text = "Войти с Яндекс", fontSize = 20.sp,
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
