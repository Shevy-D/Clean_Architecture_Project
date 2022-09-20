package com.shevy.cleanarchitectureproject.data.storage

import com.shevy.cleanarchitectureproject.data.storage.models.User
import com.shevy.cleanarchitectureproject.domain.models.UserName

interface UserStorage {

    fun save(user: User) : Boolean

    fun get(): User
}