package com.shevy.cleanarchitectureproject.domain.usecase

import com.shevy.cleanarchitectureproject.domain.models.UserName
import com.shevy.cleanarchitectureproject.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}