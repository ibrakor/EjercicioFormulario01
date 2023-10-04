package com.example.androidtrainingv2.domain

import com.example.androidtrainingv2.app.ErrorApp
import com.iesam.kotlintrainning.Either

class SaveUserUseCase(private val repository: UserRepository) {
    operator fun invoke(user :Input): Either<ErrorApp, Boolean>{
        return repository.save(user)
    }
}
data class Input(val userName: String, val surname: String, val age: Int)
