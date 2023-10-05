package com.example.androidtrainingv2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import com.example.androidtrainingv2.R
import com.example.androidtrainingv2.data.UserDataRepository
import com.example.androidtrainingv2.data.XmlLocalDataSource
import com.example.androidtrainingv2.domain.SaveUserUseCase

class MainActivity : AppCompatActivity() {
    private val viewModels: MainViewModel by lazy {
        MainViewModel(SaveUserUseCase(UserDataRepository(
        XmlLocalDataSource(this))))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio2)
        setupView()
    }
    private fun setupView(){
        val actionButton = findViewById<Button>(R.id.action_save)
        actionButton.setOnClickListener {
            viewModels.saveUser(getNameInput(),getSurnameInput(),getAgeInput())
        }
    }

    private fun getNameInput(): String =
        findViewById<EditText>(R.id.input_name).text.toString()

    private fun getSurnameInput(): String =
        findViewById<EditText>(R.id.input_surname).text.toString()
    private fun getAgeInput() : Int =
        findViewById<EditText>(R.id.input_age).text.toString().toInt()
}
