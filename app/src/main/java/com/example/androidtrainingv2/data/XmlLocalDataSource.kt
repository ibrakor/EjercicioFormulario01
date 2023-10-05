package com.example.androidtrainingv2.data

import android.content.Context
import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.SaveUserUseCase
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.left
import com.iesam.kotlintrainning.right

class XmlLocalDataSource(private val context: Context) {
    val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
    fun saveUser(user: SaveUserUseCase.Input): Either<ErrorApp, Boolean>{

         try {
             with (sharedPref.edit()) {
                // putInt("id", )
                 putString("username", user.userName)
                 putString("surname", user.surname)
                 putInt("age", user.age)
                 apply()
             }
             return true.right()
         } catch (ex: Exception){
             return ErrorApp.UnkownError.left()
         }

    }
}