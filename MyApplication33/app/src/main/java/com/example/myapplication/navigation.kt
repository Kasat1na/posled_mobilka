package com.example.myapplication

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.board.Board3
import com.example.myapplication.board.Start
import com.example.myapplication.board.Board2
import com.example.myapplication.board.Board3
import com.example.myapplication.board.Board4
import com.example.myapplication.board.Board5
import com.example.myapplication.board.Splash


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Start"
    ) {
        composable("Start"){
            Start(navController)
        }
        composable("Board2"){
            Board2(navController)
        }
        composable("Board3"){
            Board3(navController)
        }
        composable("Board4") {
            Board4(navController)
        }
        composable("Board5") {
            Board5(navController)
        }
        composable("Board6") {
            Board5(navController)
        }
        composable("Splash") {
            Splash(navController)
        }

    }
}

