package com.example.androidtrainingv2.domain

import com.example.androidtrainingv2.app.ErrorApp
import com.iesam.kotlintrainning.Either

class SaveUserUseCase(private val repository: UserRepository) {
    operator fun invoke(userName: String, surname: String): Either<ErrorApp, Boolean>{
        return repository.save(userName,surname)
    }
}