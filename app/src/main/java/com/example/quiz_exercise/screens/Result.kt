package com.example.quiz_exercise.screens

import android.R.attr.name
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz_exercise.R
import com.example.quiz_exercise.components.TextCard

@Composable
fun ResultScreen(modifier: Modifier = Modifier, navController: NavController, name: String?, points: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
            colorResource(R.color.primaria))
            .padding(0.dp, 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.quiz),
            "Quiz Logo",
            modifier = Modifier.size(120.dp)
        )

        Column(Modifier.fillMaxWidth()
            .height(120.dp)
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextCard(
                text = "Parabéns",
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("$name, você acertou $points questões..",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp)
        }


        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate("quizGame/$name")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text("Jogar Novamente",
                fontSize = 24.sp,
                color = colorResource(R.color.primaria))
        }
    }

}

