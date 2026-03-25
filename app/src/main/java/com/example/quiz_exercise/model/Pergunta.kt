package com.example.quiz_exercise.model

class Pergunta(
    val enunciado: String,
    val respostas: MutableList<Resposta> = mutableListOf()
)