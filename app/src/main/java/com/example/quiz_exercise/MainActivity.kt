package com.example.quiz_exercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz_exercise.screens.QuizScreen
import com.example.quiz_exercise.screens.ResultScreen
import com.example.quiz_exercise.screens.StartScreen
import com.example.quiz_exercise.ui.theme.QuizexerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizexerciseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    var userName: String? = ""


                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route = "login",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(1000))
                            }) {
                        StartScreen(modifier = Modifier.padding(innerPadding), navController = navController) }
                        composable(route = "quizGame/{nome}",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(1000))
                            }) { backStackEntry ->
                            userName = backStackEntry.arguments?.getString("nome")
                            QuizScreen(navController = navController, userName = userName) }
                        composable(route = "result/{nome}/{points}",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(1000))
                            }) {
                            userName = it.arguments?.getString("nome")
                            val points = it.arguments?.getString("points")
                            ResultScreen(navController = navController, modifier = Modifier, name = userName, points = points) }
                    }

                }
            }
        }
    }
}


