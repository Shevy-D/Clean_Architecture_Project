package com.shevy.cleanarchitectureproject.domain.repository

import com.shevy.cleanarchitectureproject.domain.models.SaveUserNameParam
import com.shevy.cleanarchitectureproject.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}