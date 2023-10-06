package com.example.androidtrainingv2.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.GetUserUseCase
import com.example.androidtrainingv2.domain.SaveUserUseCase
import com.example.androidtrainingv2.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val saveUserUseCase: SaveUserUseCase,
                    private val getUserUseCase: GetUserUseCase) : ViewModel() {
    
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState
    fun saveUser(name: String, surname: String, age: Int){
        val user = SaveUserUseCase.Input(name,surname,age)
        saveUserUseCase(user).fold(
            {responseError(it)},
            {responseSucces(it)}
        )
    }
    fun getUser(){
        viewModelScope.launch(Dispatchers.IO){  }
            getUserUseCase.invoke().fold(
                {responseError(it)},
                {responseGetUserSuccess(it)}
            )
    }


    private fun responseError(errorApp: ErrorApp){

    }
    private fun responseSucces(itsOk: Boolean){

    }
    private fun responseGetUserSuccess(user: User){
        _uiState.postValue(UiState(user = user))
    }
    data class UiState(
        val errorApp: ErrorApp?=null,
        val isLoading: Boolean = false,
        val user: User? = null
    )

}