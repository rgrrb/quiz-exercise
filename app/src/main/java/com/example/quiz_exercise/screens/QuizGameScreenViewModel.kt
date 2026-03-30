package com.example.quiz_exercise.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizGameViewModel: ViewModel(){

    private val _questionNumberState = MutableLiveData<Int>()
    var questionNumber: LiveData<Int> = _questionNumberState

}
