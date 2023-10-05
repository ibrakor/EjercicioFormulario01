package com.example.androidtrainingv2.presentation

import androidx.lifecycle.ViewModel
import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.Input
import com.example.androidtrainingv2.domain.SaveUserUseCase

class MainViewModel(private val saveUserUseCase: SaveUserUseCase) : ViewModel() {
    fun saveUser(name: String, surname: String, age: Int){
        val user = Input(name,surname,age)
        saveUserUseCase(user).fold(
            {responseError(it)},
            {responseSucces(it)}
        )
    }
    private fun responseError(errorApp: ErrorApp){

    }
    private fun responseSucces(itsOk: Boolean){

    }

}