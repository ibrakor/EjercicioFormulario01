package com.example.androidtrainingv2.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.SaveUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val saveUserUseCase: SaveUserUseCase) : ViewModel() {
    
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState
    fun saveUser(name: String, surname: String, age: Int){
        val user = SaveUserUseCase.Input(name,surname,age)
        saveUserUseCase(user).fold(
            {responseError(it)},
            {responseSucces(it)}
        )
    }
    fun loadUser(){
        viewModelScope.launch(Dispatchers.IO){
            Log.d("@dev","Hilo")
        }
        Log.d("@dev","Main")

    }


    private fun responseError(errorApp: ErrorApp){

    }
    private fun responseSucces(itsOk: Boolean){

    }
    data class UiState(
        val errorApp: ErrorApp?=null,
        val isLoading: Boolean = false,
        val user: SaveUserUseCase.Input? = null
    )

}