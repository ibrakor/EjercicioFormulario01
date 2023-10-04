package com.example.androidtrainingv2.presentation

import androidx.lifecycle.ViewModel
import com.example.androidtrainingv2.domain.SaveUserUseCase

class MainViewModel(private val saveUser: SaveUserUseCase) : ViewModel() {
    fun saveUser(name: String, surname: String){
        saveUser.execute(name,surname)
    }

}