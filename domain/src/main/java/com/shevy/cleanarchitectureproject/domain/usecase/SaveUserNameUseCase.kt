package com.shevy.cleanarchitectureproject.domain.usecase

import com.shevy.cleanarchitectureproject.domain.models.SaveUserNameParam
import com.shevy.cleanarchitectureproject.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}