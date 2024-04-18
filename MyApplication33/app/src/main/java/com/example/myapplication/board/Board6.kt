package com.example.myapplication.board


import androidx.annotation.ContentView
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay



fun manageFocus(
    textFields: List<MutableState<TextFieldValue>>,
    Requestersfocus: List<FocusRequester>
)
{
    for (i in textFields.indices)
    {
        if (textFields[i].value.text.isEmpty())
        {
            if (i < textFields.size)
            {
                Requestersfocus[i].requestFocus()
                break
            }
        }
    }
}
//@Preview
@Composable
fun Board6(navController: NavHostController) {
    val textFields = listOf(
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(1)
                )
            )
        },
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(1)
                )
            )
        },
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(1)
                )
            )
        },
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(1)
                )
            )
        }
    )

    val Requestersfocus = listOf(
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Введите код из E-mail", fontSize = 25.sp)
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                CustomView(textFields,Requestersfocus)
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Text(
                    text = "Отправить код повторно можно",
                    fontSize = 15.sp,
                    color = Color(0xFF939396)
                )
                var time by remember { mutableStateOf(60) }
                LaunchedEffect(key1 = time) {
                    if (time > 0) {
                        delay(1_000)
                        time -= 1
                    }
                }

                Text(
                    text = "будет через " + time.toString() + " секунд",
                    fontSize = 15.sp,
                    color = Color(0xFF939396)
                )
                /*TextButton(onClick = { navController.navigate("Board7") }) {} почему то навигация не срабатывает*/
            }
        }

    }
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomView(
    textFields: List<MutableState<TextFieldValue>>,
    Requestersfocus: List<FocusRequester>
)
{
    val manager = LocalFocusManager.current
    val keyboard = LocalSoftwareKeyboardController.current
    val textt = LocalContext.current

    Surface(
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 50.dp)
                    .align(Alignment.Center)
            ) {
                for(i in textFields.indices)
                {
                    createCustomTextField(
                        value = textFields[i].value,
                        onValueChange = {newValue ->
                            if(textFields[i].value.text!="")
                            {
                                if(newValue.text=="")
                                {
                                    textFields[i].value = TextFieldValue(
                                        text = "",
                                        selection = TextRange(0)
                                    )
                                }
                                return@createCustomTextField
                            }
                            textFields[i].value = TextFieldValue(
                                text = newValue.text,
                                selection = TextRange(newValue.text.length)
                            )
                            manageFocus(textFields,Requestersfocus)},
                        Requestersfocus = Requestersfocus[i])
                }
            }
        }
    }
    LaunchedEffect(key1 = null) {
        delay(300)
        Requestersfocus[0].requestFocus()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun createCustomTextField(
    value:TextFieldValue,
    onValueChange: (value:TextFieldValue) -> Unit,
    Requestersfocus: FocusRequester
)
{
    BasicTextField(
        readOnly = false,
        value = value,
        onValueChange = onValueChange,

        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .wrapContentSize()
            .background(Color(0xFFF5F5F9))
            .focusRequester(Requestersfocus)
            .border(1.dp,Color(0xFFEBEBEB)),
        singleLine = true,
        maxLines = 1,
        decorationBox = {
                innerTextField ->
            Box(modifier = Modifier
                .width(48.dp)
                .height(48.dp),
                contentAlignment = Alignment.Center,
            )
            {
                innerTextField()
            }
        },
        cursorBrush = SolidColor(Color.Black),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {}
        )
    )
}
