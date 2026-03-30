package com.example.quiz_exercise.components

import android.R.attr.fontStyle
import android.R.attr.fontWeight
import android.R.attr.onClick
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionBtn(modifier: Modifier, answer: String, isCorrect: Boolean) {

    var answerColor by remember {
        mutableStateOf(Color.Transparent)
    }


    Button(
        onClick = {
            if (isCorrect) {
                answerColor = Color.Green
            } else {
                answerColor = Color.Red
            }


        },
        colors = ButtonDefaults.buttonColors(
            containerColor = answerColor
        ),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, Color(0, 0, 0, 36)),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
    ) {
        Text(
            answer,
            color = Color.Black,
            fontSize = 23.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Normal
        )

    }

}
