package com.example.androidtrainingv2.data

import android.content.Context
import android.provider.Settings.Global.getString
import com.example.androidtrainingv2.R
import com.example.androidtrainingv2.app.ErrorApp
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.left
import com.iesam.kotlintrainning.right
import java.lang.Exception

class XmlLocalDataSource(private val context: Context) {
    val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
    fun saveUser(username: String, surname: String): Either<ErrorApp, Boolean>{
        /*
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("surname", surname)
        editor.apply()
        */
         try {
             with (sharedPref.edit()) {
                 putString("username", username)
                 putString("surname", surname)
                 apply()
             }
             return true.right()
         } catch (ex: Exception){
             return ErrorApp.UnkownError.left()
         }

    }
}