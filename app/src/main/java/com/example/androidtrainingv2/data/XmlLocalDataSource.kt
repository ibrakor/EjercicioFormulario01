package com.example.androidtrainingv2.data

import android.content.Context
import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.SaveUserUseCase
import com.example.androidtrainingv2.domain.User
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.left
import com.iesam.kotlintrainning.right

class XmlLocalDataSource(private val context: Context) {
    val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
    fun saveUser(user: SaveUserUseCase.Input): Either<ErrorApp, Boolean>{

         try {
             with (sharedPref.edit()) {
                 putInt("id", (1..100).random())
                 putString("username", user.userName)
                 putString("surname", user.surname)
                 putInt("age", user.age)
                 apply()
             }
             return true.right()
         } catch (ex: Exception){
             return ErrorApp.UnknownError.left()
         }

    }
    fun getUser(): Either<ErrorApp, User>{
        return try {
            User(
                sharedPref.getInt("id",0),
                sharedPref.getString("username", "")!!,
                sharedPref.getString("surname", "")!!,
                sharedPref.getInt("age", 0)
            ).right()
        } catch (ex: Exception){
            return ErrorApp.UnknownError.left()
        }
    }


}