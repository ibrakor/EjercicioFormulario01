package com.example.androidtrainingv2.domain

import com.example.androidtrainingv2.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface UserRepository {
    fun save(user: Input): Either<ErrorApp, Boolean>;

}