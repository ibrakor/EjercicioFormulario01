package com.example.androidtrainingv2.domain

import com.example.androidtrainingv2.app.ErrorApp
import com.iesam.kotlintrainning.Either

class GetUserUseCase(val userRepository: UserRepository) {
    fun invoke(): Either<ErrorApp, User>{
        return userRepository.get()
    }
}