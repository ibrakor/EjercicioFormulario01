package com.example.androidtrainingv2.data

import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.SaveUserUseCase
import com.example.androidtrainingv2.domain.User
import com.example.androidtrainingv2.domain.UserRepository
import com.iesam.kotlintrainning.Either

class UserDataRepository(private val localDataSource: XmlLocalDataSource): UserRepository {
    override fun save(user: SaveUserUseCase.Input): Either<ErrorApp, Boolean> {
        return localDataSource.saveUser(user)
    }

    override fun get(): Either<ErrorApp, User>{
        return localDataSource.getUser()
    }

}