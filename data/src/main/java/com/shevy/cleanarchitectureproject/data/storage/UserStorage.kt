package com.shevy.cleanarchitectureproject.data.storage

import com.shevy.cleanarchitectureproject.data.storage.models.User

interface UserStorage {

    fun save(user: User) : Boolean

    fun get(): User
}