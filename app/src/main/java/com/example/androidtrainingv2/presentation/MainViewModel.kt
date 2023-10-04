package com.example.androidtrainingv2.presentation

import androidx.lifecycle.ViewModel
import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.SaveUserUseCase

class MainViewModel(private val saveUserUseCase: SaveUserUseCase) : ViewModel() {
    fun saveUser(name: String, surname: String){
        saveUserUseCase(name,surname).fold(
            {responseError(it)},
            {responseSucces(it)}
        )
    }
    private fun responseError(errorApp: ErrorApp){

    }
    private fun responseSucces(itsOk: Boolean){

    }

}