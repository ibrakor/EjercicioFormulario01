package com.example.androidtrainingv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("@dev", "onStart ejectuandose")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@dev", "onResume ejectuandose")

    }

}