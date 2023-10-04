package com.example.androidtrainingv2.data

import android.content.Context
import android.provider.Settings.Global.getString
import com.example.androidtrainingv2.R
import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.Input
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.left
import com.iesam.kotlintrainning.right
import java.lang.Exception

class XmlLocalDataSource(private val context: Context) {
    val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
    fun saveUser(user: Input): Either<ErrorApp, Boolean>{
        /*
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("surname", surname)
        editor.apply()
        */
         try {
             with (sharedPref.edit()) {
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