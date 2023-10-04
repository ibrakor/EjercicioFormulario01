package com.example.androidtrainingv2.data

import com.example.androidtrainingv2.app.ErrorApp
import com.example.androidtrainingv2.domain.UserRepository
import com.iesam.kotlintrainning.Either

class UserDataRepository(private val localDataSource: XmlLocalDataSource): UserRepository {
    override fun save(name: String, surname: String): Either<ErrorApp, Boolean> {
        return localDataSource.saveUser(name,surname)
    }
}