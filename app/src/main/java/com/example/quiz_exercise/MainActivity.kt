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

                    NavHost(
                        navController = navController,
                        startDestination = "result"
                    ){
                        composable(route = "login",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(1000))
                            }) { StartScreen(modifier = Modifier.padding(innerPadding), navController = navController) }
                        composable(route = "quizGame",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(1000))
                            }) { QuizScreen(navController = navController) }
                        composable(route = "result",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(1000))
                            }) { ResultScreen(navController = navController) }
                    }

                }
            }
        }
    }
}


