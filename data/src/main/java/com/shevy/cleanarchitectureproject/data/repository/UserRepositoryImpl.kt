package com.shevy.cleanarchitectureproject.data.repository

import android.annotation.SuppressLint
import com.shevy.cleanarchitectureproject.data.storage.UserStorage
import com.shevy.cleanarchitectureproject.data.storage.models.User
import com.shevy.cleanarchitectureproject.domain.models.SaveUserNameParam
import com.shevy.cleanarchitectureproject.domain.models.UserName
import com.shevy.cleanarchitectureproject.domain.repository.UserRepository

class UserRepositoryImpl (private val userStorage: UserStorage) : UserRepository {

    @SuppressLint("CommitPrefEdits")
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

}