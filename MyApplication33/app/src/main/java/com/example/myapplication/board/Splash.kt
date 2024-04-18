package com.example.myapplication.board

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@SuppressLint("ReturnRemember")
@Composable
fun Splash (navController: NavHostController) {
    val configuration = LocalConfiguration.current
    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        LaunchedEffect(key1 = true) {
            delay(1000L)
            navController.navigate("Start") {
                popUpTo("Splash")
                {
                    inclusive = true
                }
            }
        }
    }
}