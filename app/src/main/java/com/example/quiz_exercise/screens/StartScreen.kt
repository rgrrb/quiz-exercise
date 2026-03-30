package com.example.quiz_exercise.screens

import android.R.attr.label
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz_exercise.R

@Composable
fun StartScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()
        .background(colorResource(R.color.primaria))) {
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(600.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    painterResource(R.drawable.quiz),
                    "Quiz Logo",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(35.dp))
                Text("QUIZATRON 3000!",
                    color = Color.White,
                    fontSize = 36.sp)

                var text by remember {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText },
                    label = { Text("Digite seu nome...",
                        color = Color.White) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedTextColor = Color.White,
                        cursorColor = Color.White
                    )
                )


                Button(
                    onClick = {
                        navController.navigate("quizGame/$text")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text("Começar",
                        fontSize = 24.sp,
                        color = colorResource(R.color.primaria))
                }
            }
        }

    }
}