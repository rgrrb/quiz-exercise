package com.example.quiz_exercise.screens

import android.R.attr.label
import android.R.attr.name
import android.R.attr.text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz_exercise.R
import com.example.quiz_exercise.components.QuestionBtn
import com.example.quiz_exercise.components.TextCard
import com.example.quiz_exercise.model.Pergunta
import com.example.quiz_exercise.model.Resposta

@Composable
fun QuizScreen(modifier: Modifier = Modifier, navController: NavController, userName: String?) {

    val pergunta1: Pergunta = Pergunta(
        enunciado = "Qual a capital da frança?", respostas = listOf(
            Resposta("Paris", true),
            Resposta("Marrocos"),
            Resposta("Pindanmonhangaba"),
            Resposta("Boznia")
        )
    )

    val pergunta2: Pergunta = Pergunta(
        enunciado = "Qual é o maior planeta do sistema solar?", respostas = listOf(
            Resposta("Júpiter", true), Resposta("Terra"), Resposta("Marte"), Resposta("Saturno")
        )
    )

    val pergunta3: Pergunta = Pergunta(
        enunciado = "Quem escreveu 'Dom Casmurro'?", respostas = listOf(
            Resposta("Machado de Assis", true),
            Resposta("José de Alencar"),
            Resposta("Clarice Lispector"),
            Resposta("Carlos Drummond de Andrade")
        )
    )


    val perguntas = listOf<Pergunta>(
        pergunta1, pergunta2, pergunta3
    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.primaria))
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
                .background(colorResource(R.color.primaria)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(600.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.quiz), "Quiz Logo", modifier = Modifier.size(80.dp)
                )

                var questionNumber by remember {
                    mutableStateOf(0)
                }

                var points by remember {
                    mutableStateOf(0)
                }

                TextCard(modifier = Modifier, "Pergunta ${questionNumber + 1} de 3")

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .width(350.dp)
                        .height(335.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        val perguntaAtual = perguntas[questionNumber]

                        Text(
                            text = "${perguntaAtual.enunciado}", fontSize = 24.sp
                        )

                        perguntaAtual.respostas.forEach { resposta ->
                            QuestionBtn(
                                modifier = Modifier.clickable {

                                    if (resposta.correta) {
                                        points += 1
                                    }
                                    if (questionNumber < perguntas.size - 1) {
                                        questionNumber++
                                    } else {
                                        navController.navigate("result/$userName/$points")
                                    }
                                }, resposta.texto, resposta.correta
                            )
                        }

                    }
                }


            }
        }

    }
}