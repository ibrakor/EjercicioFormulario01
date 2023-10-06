package com.example.androidtrainingv2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer

import com.example.androidtrainingv2.R
import com.example.androidtrainingv2.data.UserDataRepository
import com.example.androidtrainingv2.data.XmlLocalDataSource
import com.example.androidtrainingv2.domain.GetUserUseCase
import com.example.androidtrainingv2.domain.SaveUserUseCase
import com.example.androidtrainingv2.domain.User

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        MainViewModel(SaveUserUseCase(UserDataRepository(
        XmlLocalDataSource(this))),
            GetUserUseCase(UserDataRepository(XmlLocalDataSource(this)))
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio2)
        setupView()
        setupObservers()
    }
    private fun setupView(){
        val actionButton = findViewById<Button>(R.id.action_save)
        actionButton.setOnClickListener {
            viewModel.saveUser(getNameInput(),getSurnameInput(),getAgeInput())
        }
        val getButton = findViewById<Button>(R.id.action_get)
        getButton.setOnClickListener {
            viewModel.getUser()
        }
        val cleanButton = findViewById<Button>(R.id.action_clean)
        cleanButton.setOnClickListener {
            cleanNameInput()
            cleanSurnameInput()
            cleanAgeInput()
        }
    }
    private fun setupObservers(){
        val observer = Observer<MainViewModel.UiState>{
            it.user?.apply {
                bindData(this)
            }
        }
        viewModel.uiState.observe(this,observer)
    }

    private fun getNameInput(): String =
        findViewById<EditText>(R.id.input_name).text.toString()

    private fun getSurnameInput(): String =
        findViewById<EditText>(R.id.input_surname).text.toString()
    private fun getAgeInput() : Int =
        findViewById<EditText>(R.id.input_age).text.toString().toInt()

    private fun cleanNameInput() {
        findViewById<EditText>(R.id.input_name).text = null
    }
    private fun cleanSurnameInput(){
        findViewById<EditText>(R.id.input_surname).text = null
    }
    private fun cleanAgeInput(){
        findViewById<EditText>(R.id.input_age).text = null
    }
    private fun bindData(user: User){
        setNameInput(user.username)
        setSurnameInput(user.surname)
        setAgeInput(user.age)
    }
    private fun setNameInput(name: String){
        findViewById<EditText>(R.id.input_name).setText(name)
    }
    private fun setSurnameInput(surname: String){
        findViewById<EditText>(R.id.input_surname).setText(surname)
    }
    private fun setAgeInput(age: Int){
        findViewById<EditText>(R.id.input_age).setText(age.toString())
    }

}
